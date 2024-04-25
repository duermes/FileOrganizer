import javax.swing.*;
import java.awt.*;

public class FrameMain extends JFrame {
    FileManager fileManager;
    JComboBox<String> opcionesComboBox;
    JComboBox<String> searchButton;
    JButton actualizarButton;
    JButton borrarButton;
    JButton closeButton;
    JTextField searchField;
    JPanel resultsPanel;
    DefaultListModel<Object> model;
    JList<Object> list;
    JLabel errorMessage;
    String message;

    public FrameMain(FileManager fileManager) {
        super("File Manager");
        super.setSize(750, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        this.fileManager = fileManager;

        getContentPane().setBackground(new Color(77,196,194));
        //setLayout(new BorderLayout(30, 30));

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(202,242,242,255));
        searchPanel.setLayout(null);
        searchPanel.setBounds(15, 10, 425, 40);

        searchField = new JTextField();
        searchField.setLayout(null);
        searchField.setBounds(5,5,320,32);
        searchField.setVisible(true);


        String[] opciones2 = {"Buscar", "Tamaño:limitar", "Tamaño", "Letra"};
        searchButton = new JComboBox<>(opciones2);
        searchButton.setBounds(337, 5, 80, 32);


        resultsPanel = new JPanel();
        resultsPanel.setBackground(new Color(202,242,242,255));
        resultsPanel.setLayout(null);
        resultsPanel.setBounds(15, 60, 425, 390);

        model = new DefaultListModel<>();
        list = new JList<>(model);
        list.setBounds(5, 5, 415, 300);
        for (int i = 0; i < fileManager.getItems().length; i++) {
            FileItem item = fileManager.getItems()[i];
            model.addElement(item);

        }
        JScrollPane scrollPanel = new JScrollPane(list);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setBounds(5,5,415,380);


        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(new Color(202,242,242,255));
        optionsPanel.setLayout(null);
        optionsPanel.setBounds(460, 10, 246, 440);

        JPanel panelOrdenar = new JPanel();
        panelOrdenar.setBackground(new Color(77,196,194));
        panelOrdenar.setBounds(16, 150, 212, 41);

        String[] opciones = {"Tamaño", "Fecha de creación", "Fecha de modificación", "Nombre", "Fecha de creación y tamaño"};
        opcionesComboBox = new JComboBox<>(opciones);
        opcionesComboBox.setBounds(16, 150, 180, 27);

        JPanel panelActualizar = new JPanel();
        panelActualizar.setBackground(new Color(77,196,194));
        panelActualizar.setBounds(16, 215, 212, 41);
        actualizarButton = new JButton("Actualizar");  // mejorarlo luego
        actualizarButton.setBounds(16, 215, 146, 27);

        JPanel panelBorrar = new JPanel();
        panelBorrar.setBackground(new Color(77,196,194));
        panelBorrar.setBounds(16, 280, 212, 41);
        borrarButton = new JButton("Borrar"); //mejorarlo luego
        borrarButton.setBounds(16, 280, 180, 27);

        closeButton = new JButton("Cerrar");
        closeButton.setBounds(45, 345, 140, 41);

        errorMessage = new JLabel(message);
        errorMessage.setBounds(5, 390, 200, 20);
        errorMessage.setVisible(false);


        searchPanel.add(searchButton);

        panelOrdenar.add(opcionesComboBox);
        panelBorrar.add(borrarButton);
        panelActualizar.add(actualizarButton);

        optionsPanel.add(panelOrdenar);
        optionsPanel.add(panelActualizar);
        optionsPanel.add(panelBorrar);
        optionsPanel.add(closeButton);
        optionsPanel.add(errorMessage);

        searchPanel.add(searchField);
        resultsPanel.add(scrollPanel);

        super.add(searchPanel);
        super.add(resultsPanel);
        super.add(optionsPanel);

        actionListeners();
        setResizable(false);
        setVisible(true);
    }

    public void actionListeners() {
        actualizarButton.addActionListener(e -> {
            model.removeAllElements();
            for (int i = 0; i < fileManager.getItems().length; i++) {
                FileItem item = fileManager.getItems()[i];
                model.addElement(item);
            }
        });

        borrarButton.addActionListener(e -> {
            String name = list.getSelectedValue().toString();
            for (int i = 0; i < fileManager.getItems().length; i++) {
                if (fileManager.getItems()[i].getName().equals(name)) {
                    fileManager.removeItem(fileManager.getItems()[i]);
                    model.removeElement(fileManager.getItems()[i]);
                    break;
                }
            }

        });

        closeButton.addActionListener(e -> {
            super.dispose();
        });

        opcionesComboBox.addActionListener(e -> {
            String opcion = opcionesComboBox.getSelectedItem().toString();
            switch (opcion) {
                case "Tamaño":
                    FileUtils.sortItemsBySize(fileManager.getItems());
                    break;
                case "Fecha de creación":
                    FileUtils.sortItemsByCreationDate(fileManager.getItems());
                    break;
                case "Fecha de modificación":
                    FileUtils.sortItemsByLastModification(fileManager.getItems());
                    break;
                case "Nombre":
                    FileUtils.sortItemsByName(fileManager.getItems());
                    break;
                case "Fecha de creación y tamaño":
                    FileUtils.sortByCreationAndSize(fileManager.getItems());
                    break;
            }
            model.removeAllElements();
            for (int i = 0; i < fileManager.getItems().length; i++) {
                FileItem item = fileManager.getItems()[i];
                model.addElement(item);
            }
        });

        searchButton.addActionListener(e -> {
            String opcion;
            try {
                opcion = searchButton.getSelectedItem().toString();
                switch (opcion) {
                    case "Buscar":
                        String name = searchField.getText();
                        for (int i = 0; i < fileManager.getItems().length; i++) {
                            if (fileManager.getItems()[i].getName().equals(name)) {
                                model.removeAllElements();
                                model.addElement(fileManager.getItems()[i]);
                                break;
                            }
                        }
                        break;
                    case "Tamaño:limitar":
                        int size = Integer.parseInt(searchField.getText());
                        FileItem[] arr = FileUtils.searchBySizeAndLimitAnswer(fileManager.getItems(), size);
                        model.removeAllElements();
                        for (FileItem item : arr) {
                            model.addElement(item);
                        }
                        break;
                    case "Tamaño":
                        double size2 = Double.parseDouble(searchField.getText());
                        FileItem[] arr2 = FileUtils.searchBySize(fileManager.getItems(), size2);
                        model.removeAllElements();
                        for (FileItem item : arr2) {
                            model.addElement(item);
                        }
                        break;
                    case "Letra":
                        String letter = searchField.getText();
                        FileItem[] arr3 = FileUtils.searchPartially(fileManager.getItems(), letter);
                        model.removeAllElements();
                        for (FileItem item : arr3) {
                            model.addElement(item);
                        }
                        break;
                }
            } catch (NumberFormatException ex) {
                message = "Ingrese un número";
                errorMessage.setText(message);
                errorMessage.setVisible(true);
            } catch (NullPointerException ex) {
                message = "No se encontró resultado";
                errorMessage.setText(message);
                errorMessage.setVisible(true);
            }

        });

    }

}
