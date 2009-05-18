/*
 * This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Interfaz.java
 *
 * Created on Jan 13, 2009, 5:10:31 PM
 *
 * @author Alos, Oswa, Luis Enrique Garcia
 */

package interfaz;

import control.AppController;
import control.NoSePudoException;
import control.LouhiHighlighter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import modelo.EntidadPDF;
import modelo.Type;
import org.pdfbox.exceptions.CryptographyException;
import org.pdfbox.exceptions.InvalidPasswordException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JOptionPane;
import exceptions.DataBaseNotFoundException;
import java.util.LinkedList;
import javax.swing.event.DocumentListener;
import modelo.Author;
import modelo.Clasificacion;
import modelo.Location;
import util.OswaReader;
import modelo.RevistaID;
import control.Db4oConnectionManager;
import control.Db4oLocalConnectionManager;
import java.awt.Dimension;
import modelo.SoporteEnum;

/**
 *
 * @author alos
 */
public class Interfaz extends javax.swing.JFrame {

    LinkedList<String> listaDeCitas = new LinkedList<String>();
    LinkedList<modelo.TemporalReference> temporalReferences;//the references found
    int currentPage = 0;//a counter for the found references pages
    Vector citNodes=new Vector();//servira para el mapeo del formato de citas
    Vector nodeFormat=new Vector();//Creara el mapeo para el formato de nodos
    String citExample="";
    String nodeExample="";
    String selectedType="";
    String selectedFormat="";
    Vector msgRsrcButtons;//contiene los mensajes correspondientes a cada boton predefinido en formato de nodos
    int nodeCode=0;//auxiliar en el mapeo de tipo de nodo para msg resources
    String nodoAux="";//almacenara el nombre del nodo
    boolean trap=false;//flag - evitara uso de multiples botones en formato de citas
    boolean nuevaCita=true;
    boolean formatFlag=false;
    HashMap nodeFormatsMap=new HashMap();//contendra los formatos especificos para cada nodo - la llave sera el nombre de columna seleccionado
    HashMap nodeWeightMap=new HashMap();//contendra los valores de cada elemento que compone cada nodo, la llave sera la misma que en nodeFormatsMap
    Vector nodeWeight=new Vector(); //Almacenara temporalmente los pesos de los elementos de un nodo, el vector se guardara como valor de nodo en nodeWeightMap
    Vector lastWeight=new Vector();//Almacenara temporalmente los pesos de los elementos, obtenidos de nodeWeightMap    
    ReviewWindow revWin;
    AppController control;
    LinkedList<RevistaID> magazineList=new LinkedList<RevistaID>();
    File file2; //Almacena el archivo PDF, en caso de que la llave no sea valida esta variable ya contendra su valor
    String articleID;//Almacena el id del articulo
    //PDFPasswordIncorrectoWindow pdfPasswordIncorrectoWindow;
    String password = "";
    /** Creates new form Interfaz */
    public Interfaz(AppController control) {
        initComponents();
        this.tabs.setEnabledAt(1, false);
        this.tabs.setEnabledAt(2, false);
        this.tabs.setEnabledAt(3, false);
        this.control = control;
        initMagazineCombo();
        initTypeCombo();
        initSoporteCombo();
        revWin = new ReviewWindow(this.control);
        labelErrorCita.setVisible(false);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        
        this.password = newPassword;
        
            
            try {
               EntidadPDF elPDF = control.convertirPDFAModelo(file2, newPassword);
               
               if(elPDF==null)
                   throw new CryptographyException("No se pudo decriptar");

               SimpleDateFormat formatter = new SimpleDateFormat();


               this.tfTitulo.setText(elPDF.getTitulo());
               this.tfAutor.setText(elPDF.getAutor());
               this.tfCreador.setText(elPDF.getCreador());
               this.tfFechaDeCreacion.setText(formatter.format(elPDF.getFechaDeCreacion().getTime()));
               this.tfFechaDeModificacion.setText(formatter.format(elPDF.getFechaDeModificacion().getTime()));
               this.tfNumeroDePaginas.setText(elPDF.getNumeroDePaginas()+"");
               this.tfPalabrasClave.setText(elPDF.getPalabrasClave());
               this.tfProductor.setText(elPDF.getProductor());
               this.tfTema.setText(elPDF.getTema());

               this.areaRawData.setText(elPDF.getContenido());

               this.areaRawData.setCaretPosition(0);
               this.tabs.setEnabledAt(1, true);
               this.tabs.setEnabledAt(2, true);

            } catch (NoSePudoException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CryptographyException ex) {

                 PDFPasswordIncorrectoWindow pdfPasswordIncorrectoWindow = new PDFPasswordIncorrectoWindow(this);
                 pdfPasswordIncorrectoWindow.pack();
                 pdfPasswordIncorrectoWindow.setVisible(true);

            } catch (InvalidPasswordException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }


    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReglasWindow = new javax.swing.JFrame();
        jLabelTipoCita = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        jLabelNombreCita = new javax.swing.JLabel();
        comboFormato = new javax.swing.JComboBox();
        jScrollPaneCitaPrev = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        labelInstructionsCitation = new javax.swing.JLabel();
        labelErrorCita = new javax.swing.JLabel();
        panelFormatoCita = new javax.swing.JPanel();
        labelNodeFormatExample = new javax.swing.JLabel();
        nodeFormatExampleTxt = new javax.swing.JTextField();
        labelSelectOneNode = new javax.swing.JLabel();
        botonNuevaCita = new javax.swing.JButton();
        KBWindow = new javax.swing.JFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaDeEntidades = new javax.swing.JList();
        BotonAgregar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonSalirKB = new javax.swing.JButton();
        FormatoCitaWindow = new javax.swing.JFrame();
        labelSelectNodeElements = new javax.swing.JLabel();
        panelOpciones1 = new javax.swing.JPanel();
        addAuthor = new javax.swing.JButton();
        addDate = new javax.swing.JButton();
        addTitle = new javax.swing.JButton();
        addVolume = new javax.swing.JButton();
        addPage = new javax.swing.JButton();
        addPlace = new javax.swing.JButton();
        addPublisher = new javax.swing.JButton();
        closeControls = new javax.swing.JButton();
        panelOpciones2 = new javax.swing.JPanel();
        labelSelectKind = new javax.swing.JLabel();
        comboTipoMedio = new javax.swing.JComboBox();
        labelSelectType = new javax.swing.JLabel();
        comboTiposCitas = new javax.swing.JComboBox();
        botonNuevoTipoCita = new javax.swing.JButton();
        nuevoTipoCitaTxt = new javax.swing.JTextField();
        SeparadorWindow = new javax.swing.JFrame();
        labelSeparatorSelection = new javax.swing.JLabel();
        separadorTxt = new javax.swing.JTextField();
        labelErrorSep = new javax.swing.JLabel();
        ReglasPorNodoWindow = new javax.swing.JFrame();
        jPanelReglasNodo = new javax.swing.JPanel();
        jPanelControlesNodo = new javax.swing.JPanel();
        jLabelControlesNodo = new javax.swing.JLabel();
        botonAddUpper = new javax.swing.JButton();
        botonAddLower = new javax.swing.JButton();
        botonAddSeparator = new javax.swing.JButton();
        botonAddNumber = new javax.swing.JButton();
        labelControlsHint = new javax.swing.JLabel();
        botonPredef9 = new javax.swing.JButton();
        botonPredef8 = new javax.swing.JButton();
        jPanelReglasNodo2 = new javax.swing.JPanel();
        jScrollPaneNodoCitaPrev = new javax.swing.JScrollPane();
        tablaNodos = new javax.swing.JTable();
        labelComponentsExample = new javax.swing.JLabel();
        nodeExampleTxt = new javax.swing.JTextField();
        botonReglasOK = new javax.swing.JButton();
        PesosParaNodoWindow = new javax.swing.JFrame();
        labelSeleccioneImportancia = new javax.swing.JLabel();
        labelSumaMsg = new javax.swing.JLabel();
        labelSumaAdvert = new javax.swing.JLabel();
        panelPesos = new javax.swing.JPanel();
        labelPesoTotal = new javax.swing.JLabel();
        labelPesoDeElemento = new javax.swing.JLabel();
        pesoTotalTxt = new javax.swing.JTextField();
        pesoElemNodoTxt = new javax.swing.JTextField();
        botonOKPesosParaNodo = new javax.swing.JButton();
        labelModifiquePeso = new javax.swing.JLabel();
        labelSelectDefaultWeights = new javax.swing.JLabel();
        botonPesosDefecto = new javax.swing.JButton();
        panelElements = new javax.swing.JPanel();
        jScrollPanelElementTable = new javax.swing.JScrollPane();
        tablaElementos = new javax.swing.JTable();
        labelElegido = new javax.swing.JLabel();
        selectedElementLabel = new javax.swing.JLabel();
        AgregarWindow = new javax.swing.JFrame();
        etiqueta = new javax.swing.JLabel();
        TextFieldAgregar = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        ConfigWindow = new javax.swing.JFrame();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        TextFieldHost = new javax.swing.JTextField();
        TextFieldPort = new javax.swing.JTextField();
        TextFieldUser = new javax.swing.JTextField();
        PasswordFieldPass = new javax.swing.JPasswordField();
        GuardarConfig = new javax.swing.JButton();
        BotonSalirConfig = new javax.swing.JButton();
        tabs = new javax.swing.JTabbedPane();
        panelMetadata = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCreador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfFechaDeCreacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfFechaDeModificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNumeroDePaginas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPalabrasClave = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfProductor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfTema = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelRevistaMetadata = new javax.swing.JLabel();
        comboRevistasMetadata = new javax.swing.JComboBox();
        panelRawData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaRawData = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        panelReferenciasRAW = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneReferencias = new javax.swing.JTextPane();
        typeOfCitationCombo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        clearButtonReferencias = new javax.swing.JButton();
        panelFoundReferences = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        titleFoundReferencesTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        authorFoundReferencesTextArea = new javax.swing.JTextArea();
        publisherFoundReferencesTextField = new javax.swing.JTextField();
        dateFoundReferencesTextField = new javax.swing.JTextField();
        pagesFoundReferencesTextField = new javax.swing.JTextField();
        volumeFoundReferencesteTextField = new javax.swing.JTextField();
        authorFoundReferencesOK = new javax.swing.JButton();
        authorFoundReferencesWRONG = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        titleFoundReferencesOK = new javax.swing.JButton();
        titleFoundReferencesWrong = new javax.swing.JButton();
        publisherFoundReferencesOk = new javax.swing.JButton();
        publisherFoundReferencesWrong = new javax.swing.JButton();
        dateFoundReferencesOk = new javax.swing.JButton();
        dateFoundReferencesWrong = new javax.swing.JButton();
        pagesFoundReferencesOk = new javax.swing.JButton();
        pagesFoundReferencesWrong = new javax.swing.JButton();
        volumeFoundReferencesOk = new javax.swing.JButton();
        volumeFoundReferencesWrong = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        originalReferenceTextArea = new javax.swing.JTextArea();
        previewsButtonFoundReferences = new javax.swing.JButton();
        nextButtonFoundReferences = new javax.swing.JButton();
        counterLabelFoundReferences = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        locationFoundReferencesTextField = new javax.swing.JTextField();
        locationFoundReferencesOk = new javax.swing.JButton();
        locationFoundReferencesWrong = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        extraFoundReferencesTextArea = new javax.swing.JTextArea();
        magazineFoundReferencesTextField = new javax.swing.JTextField();
        magazineFoundReferencesOK = new javax.swing.JButton();
        magazineFoundReferencesWrong = new javax.swing.JButton();
        labelMagazineFoundRefs = new javax.swing.JLabel();
        labelTipoMedioFoundRefs = new javax.swing.JLabel();
        comboTipoFoundReferences = new javax.swing.JComboBox();
        labelISSNFoundReferences = new javax.swing.JLabel();
        labelISBNFoundReferences = new javax.swing.JLabel();
        issnFoundReferencesTextField = new javax.swing.JTextField();
        isbnFoundReferencesTextField = new javax.swing.JTextField();
        comboSoporteReferences = new javax.swing.JComboBox();
        jLabelSoporte = new javax.swing.JLabel();
        jLabelInstitucion = new javax.swing.JLabel();
        jLabelUrl = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        institutionTextField = new javax.swing.JTextField();
        urlTextField = new javax.swing.JTextField();
        numberTextField = new javax.swing.JTextField();
        menuPrincipal = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        aboutTheBoxMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        newCitation = new javax.swing.JMenuItem();
        MenuOpenPDF = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        menuReglas = new javax.swing.JMenu();
        menuKBReferencias = new javax.swing.JMenuItem();
        menuKBAutores = new javax.swing.JMenuItem();
        menuKB = new javax.swing.JMenu();
        menuItemKBEditoriales = new javax.swing.JMenuItem();
        menuItemKBAutores = new javax.swing.JMenuItem();
        menuItemKBTitulos = new javax.swing.JMenuItem();
        menuItemKBLugares = new javax.swing.JMenuItem();
        MenuItemPreferencias = new javax.swing.JMenuItem();

        ReglasWindow.setTitle("Reglas");

        jLabelTipoCita.setText("Tipo:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Libro", "Revista", "Periodico", "Pagina de internet" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        jLabelNombreCita.setText("Nombre:");

        comboFormato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Harvard", "Vancuver", "Chicago", "ISO" }));
        comboFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFormatoActionPerformed(evt);
            }
        });

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCitas.setDragEnabled(true);
        tablaCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaCitasMouseReleased(evt);
            }
        });
        jScrollPaneCitaPrev.setViewportView(tablaCitas);

        labelInstructionsCitation.setText("Posicione los componentes arrastrandolos y con click derecho en una imagen, guarde los cambios: ");

        labelErrorCita.setForeground(java.awt.Color.red);
        labelErrorCita.setText("Se debe cumplir la regla: \"nodo separador nodo separador... nodo\"");

        panelFormatoCita.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        labelNodeFormatExample.setText("Ejemplo del componente seleccionado:");

        nodeFormatExampleTxt.setEditable(false);
        nodeFormatExampleTxt.setToolTipText("Doble click para editar peso");
        nodeFormatExampleTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nodeFormatExampleTxtMouseReleased(evt);
            }
        });

        labelSelectOneNode.setText("Seleccione un componente para mostrar el formato que presenta");

        org.jdesktop.layout.GroupLayout panelFormatoCitaLayout = new org.jdesktop.layout.GroupLayout(panelFormatoCita);
        panelFormatoCita.setLayout(panelFormatoCitaLayout);
        panelFormatoCitaLayout.setHorizontalGroup(
            panelFormatoCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelFormatoCitaLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelFormatoCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(nodeFormatExampleTxt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, labelNodeFormatExample, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelFormatoCitaLayout.createSequentialGroup()
                        .add(labelSelectOneNode, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                        .add(93, 93, 93)))
                .addContainerGap())
        );
        panelFormatoCitaLayout.setVerticalGroup(
            panelFormatoCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelFormatoCitaLayout.createSequentialGroup()
                .add(labelSelectOneNode)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelNodeFormatExample)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nodeFormatExampleTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonNuevaCita.setText("Nuevo");
        botonNuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaCitaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout ReglasWindowLayout = new org.jdesktop.layout.GroupLayout(ReglasWindow.getContentPane());
        ReglasWindow.getContentPane().setLayout(ReglasWindowLayout);
        ReglasWindowLayout.setHorizontalGroup(
            ReglasWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ReglasWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(ReglasWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ReglasWindowLayout.createSequentialGroup()
                        .add(panelFormatoCita, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(ReglasWindowLayout.createSequentialGroup()
                        .add(jLabelTipoCita)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabelNombreCita)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboFormato, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(32, 32, 32)
                        .add(botonNuevaCita, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .add(212, 212, 212))))
            .add(ReglasWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPaneCitaPrev, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, ReglasWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelInstructionsCitation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
            .add(ReglasWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelErrorCita, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .add(328, 328, 328))
        );
        ReglasWindowLayout.setVerticalGroup(
            ReglasWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ReglasWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(ReglasWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelTipoCita)
                    .add(comboTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelNombreCita)
                    .add(comboFormato, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(botonNuevaCita))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 38, Short.MAX_VALUE)
                .add(labelInstructionsCitation)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelErrorCita)
                .add(19, 19, 19)
                .add(jScrollPaneCitaPrev, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelFormatoCita, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        listaDeEntidades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(listaDeEntidades);

        BotonAgregar.setText("Agregar");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });

        BotonEliminar.setText("Eliminar");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        BotonSalirKB.setText("Salir");
        BotonSalirKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirKBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout KBWindowLayout = new org.jdesktop.layout.GroupLayout(KBWindow.getContentPane());
        KBWindow.getContentPane().setLayout(KBWindowLayout);
        KBWindowLayout.setHorizontalGroup(
            KBWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(KBWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 213, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(KBWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(BotonSalirKB, 0, 0, Short.MAX_VALUE)
                    .add(BotonAgregar)
                    .add(BotonEliminar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        KBWindowLayout.setVerticalGroup(
            KBWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(KBWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(KBWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(KBWindowLayout.createSequentialGroup()
                        .add(BotonAgregar)
                        .add(18, 18, 18)
                        .add(BotonEliminar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(BotonSalirKB))
                    .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 335, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FormatoCitaWindow.setTitle("Controles Cita");
        FormatoCitaWindow.setResizable(false);

        labelSelectNodeElements.setText("Seleccione los elementos a incluir en su formato personalizado de cita:");

        panelOpciones1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        addAuthor.setText("Autor");
        addAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorActionPerformed(evt);
            }
        });

        addDate.setText("Fecha");
        addDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDateActionPerformed(evt);
            }
        });

        addTitle.setText("Titulo");
        addTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTitleActionPerformed(evt);
            }
        });

        addVolume.setText("Volumen");
        addVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVolumeActionPerformed(evt);
            }
        });

        addPage.setText("Paginas");
        addPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPageActionPerformed(evt);
            }
        });

        addPlace.setText("Lugar");
        addPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaceActionPerformed(evt);
            }
        });

        addPublisher.setText("Editorial");
        addPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelOpciones1Layout = new org.jdesktop.layout.GroupLayout(panelOpciones1);
        panelOpciones1.setLayout(panelOpciones1Layout);
        panelOpciones1Layout.setHorizontalGroup(
            panelOpciones1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOpciones1Layout.createSequentialGroup()
                .addContainerGap()
                .add(panelOpciones1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, addTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, addDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, addAuthor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 129, Short.MAX_VALUE)
                .add(panelOpciones1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(addPlace, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(addPage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelOpciones1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(addVolume, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(81, 81, 81)
                .add(addPublisher, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOpciones1Layout.setVerticalGroup(
            panelOpciones1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOpciones1Layout.createSequentialGroup()
                .add(panelOpciones1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelOpciones1Layout.createSequentialGroup()
                        .add(panelOpciones1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(addAuthor)
                            .add(addPublisher))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(addDate)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(addTitle))
                    .add(panelOpciones1Layout.createSequentialGroup()
                        .add(addVolume)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(addPage)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(addPlace)))
                .addContainerGap())
        );

        closeControls.setText("Cerrar Esta Venatana...");
        closeControls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeControlsActionPerformed(evt);
            }
        });

        panelOpciones2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caracteristicas:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        labelSelectKind.setText("Para:");

        comboTipoMedio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Revista", "Libro" }));

        labelSelectType.setText("De tipo:");

        botonNuevoTipoCita.setText("Nuevo Tipo");
        botonNuevoTipoCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoTipoCitaActionPerformed(evt);
            }
        });

        nuevoTipoCitaTxt.setEnabled(false);

        org.jdesktop.layout.GroupLayout panelOpciones2Layout = new org.jdesktop.layout.GroupLayout(panelOpciones2);
        panelOpciones2.setLayout(panelOpciones2Layout);
        panelOpciones2Layout.setHorizontalGroup(
            panelOpciones2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOpciones2Layout.createSequentialGroup()
                .addContainerGap()
                .add(panelOpciones2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelOpciones2Layout.createSequentialGroup()
                        .add(labelSelectType)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboTiposCitas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 143, Short.MAX_VALUE)
                        .add(labelSelectKind)
                        .add(34, 34, 34)
                        .add(comboTipoMedio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(panelOpciones2Layout.createSequentialGroup()
                        .add(botonNuevoTipoCita)
                        .add(18, 18, 18)
                        .add(nuevoTipoCitaTxt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelOpciones2Layout.setVerticalGroup(
            panelOpciones2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOpciones2Layout.createSequentialGroup()
                .addContainerGap()
                .add(panelOpciones2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(comboTipoMedio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelSelectKind)
                    .add(labelSelectType)
                    .add(comboTiposCitas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(panelOpciones2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonNuevoTipoCita)
                    .add(nuevoTipoCitaTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout FormatoCitaWindowLayout = new org.jdesktop.layout.GroupLayout(FormatoCitaWindow.getContentPane());
        FormatoCitaWindow.getContentPane().setLayout(FormatoCitaWindowLayout);
        FormatoCitaWindowLayout.setHorizontalGroup(
            FormatoCitaWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(FormatoCitaWindowLayout.createSequentialGroup()
                .add(FormatoCitaWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(FormatoCitaWindowLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(labelSelectNodeElements))
                    .add(FormatoCitaWindowLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(panelOpciones1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(FormatoCitaWindowLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(panelOpciones2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(FormatoCitaWindowLayout.createSequentialGroup()
                        .add(182, 182, 182)
                        .add(closeControls)))
                .addContainerGap())
        );
        FormatoCitaWindowLayout.setVerticalGroup(
            FormatoCitaWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(FormatoCitaWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelSelectNodeElements)
                .add(18, 18, 18)
                .add(panelOpciones1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(panelOpciones2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(closeControls)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        SeparadorWindow.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        SeparadorWindow.setTitle("Separador");

        labelSeparatorSelection.setText("Ingrese el separador que estara detras del elemento:");

        separadorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separadorTxtActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout SeparadorWindowLayout = new org.jdesktop.layout.GroupLayout(SeparadorWindow.getContentPane());
        SeparadorWindow.getContentPane().setLayout(SeparadorWindowLayout);
        SeparadorWindowLayout.setHorizontalGroup(
            SeparadorWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(SeparadorWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(SeparadorWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelSeparatorSelection, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .add(separadorTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelErrorSep, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
        SeparadorWindowLayout.setVerticalGroup(
            SeparadorWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(SeparadorWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelSeparatorSelection)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(labelErrorSep)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(separadorTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ReglasPorNodoWindow.setTitle("Modificando:");

        jPanelReglasNodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanelControlesNodo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelControlesNodo.setText("Controles:");

        org.jdesktop.layout.GroupLayout jPanelControlesNodoLayout = new org.jdesktop.layout.GroupLayout(jPanelControlesNodo);
        jPanelControlesNodo.setLayout(jPanelControlesNodoLayout);
        jPanelControlesNodoLayout.setHorizontalGroup(
            jPanelControlesNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelControlesNodoLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(jLabelControlesNodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelControlesNodoLayout.setVerticalGroup(
            jPanelControlesNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelControlesNodoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelControlesNodo)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAddUpper.setText("Mayuscula");
        botonAddUpper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddUpperActionPerformed(evt);
            }
        });

        botonAddLower.setText("Minuscula");
        botonAddLower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddLowerActionPerformed(evt);
            }
        });

        botonAddSeparator.setText("Separador");
        botonAddSeparator.setEnabled(false);
        botonAddSeparator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddSeparatorActionPerformed(evt);
            }
        });

        botonAddNumber.setText("Numero");
        botonAddNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddNumberActionPerformed(evt);
            }
        });

        labelControlsHint.setText("Las mayusculas, minusculas y numeros representan una o mas");

        botonPredef9.setText("Year");
        botonPredef9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPredef9ActionPerformed(evt);
            }
        });

        botonPredef8.setText("Day");
        botonPredef8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPredef8ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelReglasNodoLayout = new org.jdesktop.layout.GroupLayout(jPanelReglasNodo);
        jPanelReglasNodo.setLayout(jPanelReglasNodoLayout);
        jPanelReglasNodoLayout.setHorizontalGroup(
            jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelReglasNodoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelReglasNodoLayout.createSequentialGroup()
                        .add(jPanelControlesNodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(67, 67, 67)
                        .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, botonAddNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, botonAddUpper, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, Short.MAX_VALUE))
                        .add(56, 56, 56)
                        .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(botonAddLower, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .add(botonPredef8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .add(62, 62, 62)
                        .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(botonPredef9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(botonAddSeparator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)))
                    .add(labelControlsHint, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 496, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelReglasNodoLayout.setVerticalGroup(
            jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelReglasNodoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(botonAddSeparator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .add(botonAddLower, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .add(botonAddUpper, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelControlesNodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(5, 5, 5)
                .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(botonPredef9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .add(jPanelReglasNodoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(botonAddNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .add(botonPredef8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelControlsHint)
                .addContainerGap())
        );

        jPanelReglasNodo2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vista previa"));

        tablaNodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneNodoCitaPrev.setViewportView(tablaNodos);

        labelComponentsExample.setText("Ejemplo:");

        nodeExampleTxt.setEditable(false);
        nodeExampleTxt.setDisabledTextColor(java.awt.Color.black);

        botonReglasOK.setText("OK");
        botonReglasOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReglasOKActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelReglasNodo2Layout = new org.jdesktop.layout.GroupLayout(jPanelReglasNodo2);
        jPanelReglasNodo2.setLayout(jPanelReglasNodo2Layout);
        jPanelReglasNodo2Layout.setHorizontalGroup(
            jPanelReglasNodo2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelReglasNodo2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelReglasNodo2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanelReglasNodo2Layout.createSequentialGroup()
                        .add(labelComponentsExample, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nodeExampleTxt))
                    .add(jScrollPaneNodoCitaPrev, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 537, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(botonReglasOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelReglasNodo2Layout.setVerticalGroup(
            jPanelReglasNodo2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelReglasNodo2Layout.createSequentialGroup()
                .add(jScrollPaneNodoCitaPrev, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanelReglasNodo2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelComponentsExample, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nodeExampleTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(botonReglasOK))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout ReglasPorNodoWindowLayout = new org.jdesktop.layout.GroupLayout(ReglasPorNodoWindow.getContentPane());
        ReglasPorNodoWindow.getContentPane().setLayout(ReglasPorNodoWindowLayout);
        ReglasPorNodoWindowLayout.setHorizontalGroup(
            ReglasPorNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, ReglasPorNodoWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(ReglasPorNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelReglasNodo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelReglasNodo2, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ReglasPorNodoWindowLayout.setVerticalGroup(
            ReglasPorNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ReglasPorNodoWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelReglasNodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanelReglasNodo2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PesosParaNodoWindow.setTitle("Importancia Por Elemento");

        labelSeleccioneImportancia.setText("Seleccione una importancia para cada elemento:");

        labelSumaMsg.setText("La suma del peso de los elementos debe ser 100");

        labelSumaAdvert.setText("Si la suma total no es 100, los pesos no se guardaran.");

        panelPesos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelPesoTotal.setText("Total:");

        labelPesoDeElemento.setText("Peso: ");

        pesoTotalTxt.setEditable(false);

        pesoElemNodoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoElemNodoTxtActionPerformed(evt);
            }
        });

        botonOKPesosParaNodo.setText("OK");
        botonOKPesosParaNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOKPesosParaNodoActionPerformed(evt);
            }
        });

        labelModifiquePeso.setText("Modifique el peso y pulse \"Enter\"");

        labelSelectDefaultWeights.setText("O seleccione los valores por defecto:");

        botonPesosDefecto.setText("Defecto");
        botonPesosDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPesosDefectoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelPesosLayout = new org.jdesktop.layout.GroupLayout(panelPesos);
        panelPesos.setLayout(panelPesosLayout);
        panelPesosLayout.setHorizontalGroup(
            panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelPesosLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(labelPesoTotal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(labelPesoDeElemento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pesoTotalTxt)
                    .add(pesoElemNodoTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelPesosLayout.createSequentialGroup()
                        .add(labelSelectDefaultWeights, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(botonPesosDefecto)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(botonOKPesosParaNodo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(labelModifiquePeso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPesosLayout.setVerticalGroup(
            panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelPesosLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(pesoElemNodoTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(labelPesoDeElemento)
                    .add(labelModifiquePeso))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(pesoTotalTxt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(labelPesoTotal))
                    .add(panelPesosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(labelSelectDefaultWeights)
                        .add(botonOKPesosParaNodo)
                        .add(botonPesosDefecto)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelElements.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elementos:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tablaElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaElementos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaElementosMouseReleased(evt);
            }
        });
        jScrollPanelElementTable.setViewportView(tablaElementos);

        org.jdesktop.layout.GroupLayout panelElementsLayout = new org.jdesktop.layout.GroupLayout(panelElements);
        panelElements.setLayout(panelElementsLayout);
        panelElementsLayout.setHorizontalGroup(
            panelElementsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelElementsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPanelElementTable, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelElementsLayout.setVerticalGroup(
            panelElementsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelElementsLayout.createSequentialGroup()
                .add(jScrollPanelElementTable, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelElegido.setText("Elegido: ");

        selectedElementLabel.setText("<Ninguno>");

        org.jdesktop.layout.GroupLayout PesosParaNodoWindowLayout = new org.jdesktop.layout.GroupLayout(PesosParaNodoWindow.getContentPane());
        PesosParaNodoWindow.getContentPane().setLayout(PesosParaNodoWindowLayout);
        PesosParaNodoWindowLayout.setHorizontalGroup(
            PesosParaNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, PesosParaNodoWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(PesosParaNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panelElements, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panelPesos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelSeleccioneImportancia, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelSumaMsg, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelSumaAdvert, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, PesosParaNodoWindowLayout.createSequentialGroup()
                        .add(labelElegido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(selectedElementLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PesosParaNodoWindowLayout.setVerticalGroup(
            PesosParaNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PesosParaNodoWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(labelSeleccioneImportancia)
                .add(18, 18, 18)
                .add(labelSumaMsg)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(labelSumaAdvert)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(PesosParaNodoWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(labelElegido)
                    .add(selectedElementLabel))
                .add(18, 18, 18)
                .add(panelElements, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelPesos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout AgregarWindowLayout = new org.jdesktop.layout.GroupLayout(AgregarWindow.getContentPane());
        AgregarWindow.getContentPane().setLayout(AgregarWindowLayout);
        AgregarWindowLayout.setHorizontalGroup(
            AgregarWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(AgregarWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(AgregarWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(AgregarWindowLayout.createSequentialGroup()
                        .add(etiqueta)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 83, Short.MAX_VALUE)
                        .add(TextFieldAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, AgregarWindowLayout.createSequentialGroup()
                        .add(BotonGuardar)
                        .add(206, 206, 206))))
        );
        AgregarWindowLayout.setVerticalGroup(
            AgregarWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(AgregarWindowLayout.createSequentialGroup()
                .add(35, 35, 35)
                .add(AgregarWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(etiqueta)
                    .add(TextFieldAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(BotonGuardar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        ConfigWindow.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ConfigWindowComponentShown(evt);
            }
        });

        jLabel38.setText("Host :");

        jLabel39.setText("Port  :");

        jLabel40.setText("User :");

        jLabel41.setText("Pass :");

        GuardarConfig.setText("Guardar");
        GuardarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarConfigActionPerformed(evt);
            }
        });

        BotonSalirConfig.setText("Salir");
        BotonSalirConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirConfigActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout ConfigWindowLayout = new org.jdesktop.layout.GroupLayout(ConfigWindow.getContentPane());
        ConfigWindow.getContentPane().setLayout(ConfigWindowLayout);
        ConfigWindowLayout.setHorizontalGroup(
            ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ConfigWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ConfigWindowLayout.createSequentialGroup()
                        .add(jLabel38)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(TextFieldHost, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                    .add(ConfigWindowLayout.createSequentialGroup()
                        .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel39)
                            .add(jLabel40)
                            .add(jLabel41))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(ConfigWindowLayout.createSequentialGroup()
                                .add(GuardarConfig)
                                .add(74, 74, 74)
                                .add(BotonSalirConfig, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                            .add(PasswordFieldPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .add(TextFieldUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .add(TextFieldPort, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))))
                .addContainerGap())
        );
        ConfigWindowLayout.setVerticalGroup(
            ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ConfigWindowLayout.createSequentialGroup()
                .addContainerGap()
                .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel38)
                    .add(TextFieldHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel39)
                    .add(TextFieldPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel40)
                    .add(TextFieldUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel41)
                    .add(PasswordFieldPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(ConfigWindowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(BotonSalirConfig)
                    .add(GuardarConfig))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SERBIA");

        jLabel1.setText("Titulo:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Creador:");

        jLabel4.setText("Fecha de creacion:");

        jLabel5.setText("Fecha de modificacion:");

        jLabel6.setText("Numero de paginas:");

        jLabel7.setText("Palabras clave:");

        jLabel8.setText("Productor:");

        jLabel9.setText("Tema:");

        jLabel10.setText("...zzzZZZzzz...");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/metadata_1.png"))); // NOI18N

        labelRevistaMetadata.setText("Revista:");

        org.jdesktop.layout.GroupLayout panelMetadataLayout = new org.jdesktop.layout.GroupLayout(panelMetadata);
        panelMetadata.setLayout(panelMetadataLayout);
        panelMetadataLayout.setHorizontalGroup(
            panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMetadataLayout.createSequentialGroup()
                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelMetadataLayout.createSequentialGroup()
                        .add(137, 137, 137)
                        .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel10)
                            .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 506, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(panelMetadataLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel11)
                            .add(panelMetadataLayout.createSequentialGroup()
                                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(panelMetadataLayout.createSequentialGroup()
                                        .add(jLabel4)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(tfFechaDeCreacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(jLabel5)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(tfFechaDeModificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 187, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(panelMetadataLayout.createSequentialGroup()
                                        .add(jLabel9)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(tfTema, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(48, 48, 48)
                                        .add(labelRevistaMetadata, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(comboRevistasMetadata, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 372, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, panelMetadataLayout.createSequentialGroup()
                                                .add(jLabel1)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(tfTitulo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, panelMetadataLayout.createSequentialGroup()
                                                .add(jLabel7)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(tfPalabrasClave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(18, 18, 18)
                                                .add(jLabel8)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(tfProductor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 211, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, panelMetadataLayout.createSequentialGroup()
                                            .add(jLabel2)
                                            .add(14, 14, 14)
                                            .add(tfAutor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(18, 18, 18)
                                            .add(jLabel3)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(tfCreador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(18, 18, 18)
                                            .add(jLabel6)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(tfNumeroDePaginas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(28, 28, 28)))))
                .addContainerGap())
        );
        panelMetadataLayout.setVerticalGroup(
            panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMetadataLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE, false)
                    .add(jLabel1)
                    .add(tfTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfAutor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(tfCreador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(tfNumeroDePaginas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfFechaDeCreacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(tfFechaDeModificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(tfPalabrasClave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8)
                    .add(tfProductor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelMetadataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tfTema, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(labelRevistaMetadata)
                    .add(comboRevistasMetadata, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(247, 247, 247)
                .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel10)
                .add(182, 182, 182)
                .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(401, 401, 401))
        );

        tabs.addTab("Metadata", panelMetadata);

        areaRawData.setColumns(20);
        areaRawData.setEditable(false);
        areaRawData.setRows(5);
        areaRawData.setToolTipText("Texto encontrado dentro del PDF");
        jScrollPane1.setViewportView(areaRawData);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/Raw.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout panelRawDataLayout = new org.jdesktop.layout.GroupLayout(panelRawData);
        panelRawData.setLayout(panelRawDataLayout);
        panelRawDataLayout.setHorizontalGroup(
            panelRawDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelRawDataLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelRawDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                    .add(jLabel12))
                .addContainerGap())
        );
        panelRawDataLayout.setVerticalGroup(
            panelRawDataLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelRawDataLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 623, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(jLabel12)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tabs.addTab("Raw Data", panelRawData);

        panelReferenciasRAW.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelReferenciasRAWShown(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/referencia.png"))); // NOI18N

        textPaneReferencias.setEditable(false);
        jScrollPane2.setViewportView(textPaneReferencias);

        typeOfCitationCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chicago", "Harvard", "AMA", "APA", "MLA" }));

        jLabel16.setText("<html>T&eacute;cnica usada:</html>");

        clearButtonReferencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/limpiar_1.png"))); // NOI18N
        clearButtonReferencias.setToolTipText("Este boton permite limpiar el area de trabajo. ");
        clearButtonReferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonReferenciasActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelReferenciasRAWLayout = new org.jdesktop.layout.GroupLayout(panelReferenciasRAW);
        panelReferenciasRAW.setLayout(panelReferenciasRAWLayout);
        panelReferenciasRAWLayout.setHorizontalGroup(
            panelReferenciasRAWLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelReferenciasRAWLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelReferenciasRAWLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel13)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelReferenciasRAWLayout.createSequentialGroup()
                        .add(panelReferenciasRAWLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, panelReferenciasRAWLayout.createSequentialGroup()
                                .add(jLabel16)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(typeOfCitationCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 468, Short.MAX_VALUE)
                                .add(clearButtonReferencias))
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelReferenciasRAWLayout.setVerticalGroup(
            panelReferenciasRAWLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelReferenciasRAWLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelReferenciasRAWLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel16)
                    .add(typeOfCitationCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(clearButtonReferencias))
                .add(23, 23, 23)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 566, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel13)
                .add(38, 38, 38))
        );

        tabs.addTab("Referencias", panelReferenciasRAW);

        panelFoundReferences.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                citasComponentShown(evt);
            }
        });
        panelFoundReferences.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("Autores:");
        panelFoundReferences.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel18.setText("Editorial:");
        panelFoundReferences.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel19.setText("Fecha:");
        panelFoundReferences.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        jLabel20.setText("<html>P&aacute;ginas:</html>");
        panelFoundReferences.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, 20));

        jLabel21.setText("Volumen:");
        panelFoundReferences.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel22.setText("Titulo:");
        panelFoundReferences.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        titleFoundReferencesTextField.setEditable(false);
        panelFoundReferences.add(titleFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 560, 30));

        authorFoundReferencesTextArea.setColumns(20);
        authorFoundReferencesTextArea.setEditable(false);
        authorFoundReferencesTextArea.setRows(2);
        jScrollPane4.setViewportView(authorFoundReferencesTextArea);

        panelFoundReferences.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 560, 50));
        panelFoundReferences.add(publisherFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 200, -1));

        dateFoundReferencesTextField.setEditable(false);
        panelFoundReferences.add(dateFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 130, 20));

        pagesFoundReferencesTextField.setEditable(false);
        panelFoundReferences.add(pagesFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 130, 20));

        volumeFoundReferencesteTextField.setEditable(false);
        panelFoundReferences.add(volumeFoundReferencesteTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 200, -1));

        authorFoundReferencesOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        authorFoundReferencesOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorFoundReferencesOKActionPerformed(evt);
            }
        });
        panelFoundReferences.add(authorFoundReferencesOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));

        authorFoundReferencesWRONG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        authorFoundReferencesWRONG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorFoundReferencesWRONGActionPerformed(evt);
            }
        });
        panelFoundReferences.add(authorFoundReferencesWRONG, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));
        panelFoundReferences.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 790, 10));

        titleFoundReferencesOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        titleFoundReferencesOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFoundReferencesOKActionPerformed(evt);
            }
        });
        panelFoundReferences.add(titleFoundReferencesOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, -1));

        titleFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        titleFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(titleFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));

        publisherFoundReferencesOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        publisherFoundReferencesOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherFoundReferencesOkActionPerformed(evt);
            }
        });
        panelFoundReferences.add(publisherFoundReferencesOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        publisherFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        publisherFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(publisherFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        dateFoundReferencesOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        dateFoundReferencesOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFoundReferencesOkActionPerformed(evt);
            }
        });
        panelFoundReferences.add(dateFoundReferencesOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, -1, 40));

        dateFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        dateFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(dateFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, 40));

        pagesFoundReferencesOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        pagesFoundReferencesOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagesFoundReferencesOkActionPerformed(evt);
            }
        });
        panelFoundReferences.add(pagesFoundReferencesOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, -1, 40));

        pagesFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        pagesFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagesFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(pagesFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, -1, 40));

        volumeFoundReferencesOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        volumeFoundReferencesOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumeFoundReferencesOkActionPerformed(evt);
            }
        });
        panelFoundReferences.add(volumeFoundReferencesOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        volumeFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        volumeFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumeFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(volumeFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        jLabel23.setText("Referencia original:");
        panelFoundReferences.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        originalReferenceTextArea.setColumns(20);
        originalReferenceTextArea.setLineWrap(true);
        originalReferenceTextArea.setRows(5);
        originalReferenceTextArea.setToolTipText("Esta es la cita original a partir de la cual se intento hacer el proceso de reconocimiento. Puedes copiar y pegar desde aqui si lo prefieres");
        jScrollPane8.setViewportView(originalReferenceTextArea);

        panelFoundReferences.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 630, -1));

        previewsButtonFoundReferences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/retroceder.png"))); // NOI18N
        previewsButtonFoundReferences.setBorderPainted(false);
        previewsButtonFoundReferences.setEnabled(false);
        previewsButtonFoundReferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewsButtonFoundReferencesActionPerformed(evt);
            }
        });
        panelFoundReferences.add(previewsButtonFoundReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, -1, -1));

        nextButtonFoundReferences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/avanzar_1.png"))); // NOI18N
        nextButtonFoundReferences.setBorderPainted(false);
        nextButtonFoundReferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonfoundReferences(evt);
            }
        });
        panelFoundReferences.add(nextButtonFoundReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 690, -1, -1));

        counterLabelFoundReferences.setText("1/1");
        panelFoundReferences.add(counterLabelFoundReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 740, -1, -1));

        jLabel14.setText("Lugar:");
        panelFoundReferences.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        locationFoundReferencesTextField.setEditable(false);
        panelFoundReferences.add(locationFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 200, -1));

        locationFoundReferencesOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        locationFoundReferencesOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationFoundReferencesOkActionPerformed(evt);
            }
        });
        panelFoundReferences.add(locationFoundReferencesOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        locationFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        locationFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(locationFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, -1));

        jLabel15.setText("Extra:");
        panelFoundReferences.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, -1));

        extraFoundReferencesTextArea.setColumns(20);
        extraFoundReferencesTextArea.setRows(2);
        jScrollPane3.setViewportView(extraFoundReferencesTextArea);

        panelFoundReferences.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 350, 90));

        magazineFoundReferencesTextField.setEditable(false);
        panelFoundReferences.add(magazineFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 560, 30));

        magazineFoundReferencesOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhicorrecto30pxl_1.png"))); // NOI18N
        magazineFoundReferencesOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magazineFoundReferencesOKActionPerformed(evt);
            }
        });
        panelFoundReferences.add(magazineFoundReferencesOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));

        magazineFoundReferencesWrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/iconos/louhifalso30pxl_1.png"))); // NOI18N
        magazineFoundReferencesWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magazineFoundReferencesWrongActionPerformed(evt);
            }
        });
        panelFoundReferences.add(magazineFoundReferencesWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));

        labelMagazineFoundRefs.setText("Revista:");
        panelFoundReferences.add(labelMagazineFoundRefs, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        labelTipoMedioFoundRefs.setText("Tipo:");
        panelFoundReferences.add(labelTipoMedioFoundRefs, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 40, -1));

        panelFoundReferences.add(comboTipoFoundReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 190, -1));

        labelISSNFoundReferences.setText("ISSN:");
        panelFoundReferences.add(labelISSNFoundReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 50, -1));

        labelISBNFoundReferences.setText("ISBN:");
        panelFoundReferences.add(labelISBNFoundReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, -1, -1));
        panelFoundReferences.add(issnFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 130, 20));
        panelFoundReferences.add(isbnFoundReferencesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, 130, 20));

        panelFoundReferences.add(comboSoporteReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 190, -1));

        jLabelSoporte.setText("Sorte:");
        panelFoundReferences.add(jLabelSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, -1, 20));

        jLabelInstitucion.setText("Institucion:");
        panelFoundReferences.add(jLabelInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jLabelUrl.setText("URL:");
        panelFoundReferences.add(jLabelUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, -1, -1));

        jLabelNumero.setText("Numero:");
        panelFoundReferences.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));
        panelFoundReferences.add(institutionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 200, -1));
        panelFoundReferences.add(urlTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, 280, -1));
        panelFoundReferences.add(numberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 200, -1));

        tabs.addTab("Referencias Encontradas", panelFoundReferences);

        MenuFile.setText("SERBIA");
        MenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileActionPerformed(evt);
            }
        });

        aboutTheBoxMenu.setText("About the box...");
        aboutTheBoxMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutTheBoxMenuActionPerformed(evt);
            }
        });
        MenuFile.add(aboutTheBoxMenu);
        MenuFile.add(jSeparator2);

        newCitation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        newCitation.setText("Nueva Cita");
        newCitation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCitationActionPerformed(evt);
            }
        });
        MenuFile.add(newCitation);

        MenuOpenPDF.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        MenuOpenPDF.setText("Abrir PDF");
        MenuOpenPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOpenPDFActionPerformed(evt);
            }
        });
        MenuFile.add(MenuOpenPDF);

        MenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MenuSalir.setText("Salir");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        MenuFile.add(MenuSalir);

        menuPrincipal.add(MenuFile);

        MenuEdit.setText("Edit");

        menuReglas.setText("Reglas");

        menuKBReferencias.setText("Referencias");
        menuKBReferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKBReferenciasActionPerformed(evt);
            }
        });
        menuReglas.add(menuKBReferencias);

        menuKBAutores.setText("Autores");
        menuReglas.add(menuKBAutores);

        MenuEdit.add(menuReglas);

        menuKB.setText("Base de conocimientos");

        menuItemKBEditoriales.setText("Editoriales");
        menuItemKBEditoriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKBEditorialesActionPerformed(evt);
            }
        });
        menuKB.add(menuItemKBEditoriales);

        menuItemKBAutores.setText("Autores");
        menuItemKBAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKBAutoresActionPerformed(evt);
            }
        });
        menuKB.add(menuItemKBAutores);

        menuItemKBTitulos.setText("Titulos");
        menuItemKBTitulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKBTitulosActionPerformed(evt);
            }
        });
        menuKB.add(menuItemKBTitulos);

        menuItemKBLugares.setText("Lugares");
        menuItemKBLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKBLugaresActionPerformed(evt);
            }
        });
        menuKB.add(menuItemKBLugares);

        MenuEdit.add(menuKB);

        MenuItemPreferencias.setText("Preferencias");
        MenuItemPreferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemPreferenciasActionPerformed(evt);
            }
        });
        MenuEdit.add(MenuItemPreferencias);

        menuPrincipal.add(MenuEdit);

        setJMenuBar(menuPrincipal);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(tabs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(tabs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("static-access")
    private void MenuOpenPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOpenPDFActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            file2 = fc.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName() + ".");
            //almacenamos el id del articulo
            articleID = file.getName();
            String []auxName = articleID.split("[.]");
            articleID = auxName[0];
            
            try {
               EntidadPDF elPDF = control.convertirPDFAModelo(file);

               if(elPDF==null)
                   throw new CryptographyException("No se pudo decriptar");

               SimpleDateFormat formatter = new SimpleDateFormat();

              
               this.tfTitulo.setText(elPDF.getTitulo());
               this.tfAutor.setText(elPDF.getAutor());
               this.tfCreador.setText(elPDF.getCreador());
               this.tfFechaDeCreacion.setText(formatter.format(elPDF.getFechaDeCreacion().getTime()));
               this.tfFechaDeModificacion.setText(formatter.format(elPDF.getFechaDeModificacion().getTime()));
               this.tfNumeroDePaginas.setText(elPDF.getNumeroDePaginas()+"");
               this.tfPalabrasClave.setText(elPDF.getPalabrasClave());
               this.tfProductor.setText(elPDF.getProductor());
               this.tfTema.setText(elPDF.getTema());
               
               this.areaRawData.setText(elPDF.getContenido());

               this.areaRawData.setCaretPosition(0);
               this.tabs.setEnabledAt(1, true);
               this.tabs.setEnabledAt(2, true);

            } catch (NoSePudoException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CryptographyException ex) {
                 Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                 PDFPasswordIncorrectoWindow pdfPasswordIncorrectoWindow = new PDFPasswordIncorrectoWindow(this);
                 pdfPasswordIncorrectoWindow.pack();
                 pdfPasswordIncorrectoWindow.setTitle("Captura de un nuevo Password");
                 pdfPasswordIncorrectoWindow.setDefaultLookAndFeelDecorated(false);
                 pdfPasswordIncorrectoWindow.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                 pdfPasswordIncorrectoWindow.setResizable(false);
                 pdfPasswordIncorrectoWindow.setVisible(true);
                //Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidPasswordException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Open command cancelled by user.");
        }

    }//GEN-LAST:event_MenuOpenPDFActionPerformed

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        Db4oConnectionManager.closeDB();
        Db4oLocalConnectionManager.closeDB();
        System.exit(0);
    }//GEN-LAST:event_MenuSalirActionPerformed

    private void panelReferenciasRAWShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelReferenciasRAWShown
        this.listaDeCitas = new LinkedList<String>();
        cleanGUI();
        String content = this.areaRawData.getText();
        String reference="";
        try{
            reference = control.findReferences(content);
        }catch(DataBaseNotFoundException e){
            e.printStackTrace();
        }

        this.textPaneReferencias.setText(reference);
        this.textPaneReferencias.setCaretPosition(0);
        this.tabs.setEnabledAt(3, true);
}//GEN-LAST:event_panelReferenciasRAWShown

    private void menuKBReferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKBReferenciasActionPerformed
        this.ReglasWindow.pack();
        this.ReglasWindow.setVisible(true);
        citNodes=new Vector();
        nodeFormat=new Vector();
        buildCitTable();
        citExample="";
        tablaCitas.setToolTipText(citExample);
        nodeFormatExampleTxt.setText("");
        nodeFormatsMap.clear();
    }//GEN-LAST:event_menuKBReferenciasActionPerformed

    private void menuItemKBEditorialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKBEditorialesActionPerformed
        try{
            LinkedList lista = control.retrieveAllPublishers();
            this.listaDeEntidades.setListData(lista.toArray());
            this.KBWindow.setTitle("Editoriales");
            this.KBWindow.pack();
            this.KBWindow.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "La configuración del servidor no es correcta,\nrevise las preferencias en el menu 'edit'.");
        }
    }//GEN-LAST:event_menuItemKBEditorialesActionPerformed

    private void menuItemKBAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKBAutoresActionPerformed
        try{
            LinkedList lista = control.retrieveAllAuthors();
            this.listaDeEntidades.setListData(lista.toArray());
            this.KBWindow.setTitle("Autores");
            this.KBWindow.pack();
            this.KBWindow.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "La configuración del servidor no es correcta,\nrevise las preferencias en el menu 'edit'.");
        }
    }//GEN-LAST:event_menuItemKBAutoresActionPerformed

    
    private void addTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTitleActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Titulo";
            addTitle.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
}//GEN-LAST:event_addTitleActionPerformed

    private void closeControlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeControlsActionPerformed
        tablaCitas.setToolTipText(citExample);
        selectedType=(String)comboTipoMedio.getSelectedItem();
        selectedFormat=(String)comboTiposCitas.getSelectedItem();
        FormatoCitaWindow.setVisible(false);
        buildCitTable();
}//GEN-LAST:event_closeControlsActionPerformed

    public void initTypeCombo(){
        String [] typesList= GUIRenderer.getTypeElements();
        for(int i=0; i<typesList.length;i++){
            comboTipoFoundReferences.addItem(typesList[i]);
        }
        comboTipoFoundReferences.setRenderer(new GUIRenderer(). new TypeComboBoxRenderer());
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(0);
    }


    /*
     * Initializes the Soporte's combo
     */
   public void initSoporteCombo(){
        String [] soporteList= GUIRenderer.getSoporteElements();
        for(int i =0;i<soporteList.length;i++){
           comboSoporteReferences.addItem(soporteList[i]);
        }
        comboSoporteReferences.setRenderer(new GUIRenderer(). new SoporteComboBoxRenderer());
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(0);
   }


/**
 * Initializes the Magazine's combo
 */
    public void initMagazineCombo(){ 
        magazineList=GUIRenderer.retrieveAllMagazinesAndID();
        //comboRevistasMetadata=new javax.swing.JComboBox( GUIRenderer.getMagazineNames(magazineList));
        String[] listMag=GUIRenderer.getMagazineNames(magazineList);
        for (int i=0;i<listMag.length;i++){
            comboRevistasMetadata.addItem(listMag[i]);
            //ComboBoxNombreRevista.addItem(listMag[i]);
        }
        comboRevistasMetadata.repaint();
        //ComboBoxNombreRevista.repaint();
    }

    /**
     * Builds the Citation table, including the respective icons for each column
     */
    public void buildCitTable(){
        citExample="";

        if (citNodes==null)
            citNodes=new Vector();

        for(int i=0; i<citNodes.size();i++){
            citExample+= (String) citNodes.elementAt(i);
        }
        tablaCitas.setToolTipText(citExample);
        String[][] datos=new String[1][4];
        String[] cabecera=new String[citNodes.size()];
        for (int i=0;i<citNodes.size();i++){
            cabecera[i]=citNodes.elementAt(i).toString().substring(0, (citNodes.elementAt(i).toString().length()-1) );
        }
        DefaultTableModel dtm=new DefaultTableModel(datos,cabecera);
        tablaCitas.setModel(dtm);
        for(int i=0;i<cabecera.length;i++){
            if (cabecera[i].equals("Autor")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"autor_R-60x60.png"));
                tryAddingNode("Autor");//agrega a hash de pesos el nodo actual
            }
            if (cabecera[i].equals("Fecha")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"fecha_R-60x60.png"));
                tryAddingNode("Fecha");
            }
            if (cabecera[i].equals("Titulo")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"titulo_R-60x60.png"));
                tryAddingNode("Titulo");
            }
            if (cabecera[i].equals("Volumen")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"volumen_R-60x60.png"));
                tryAddingNode("Volumen");
            }
            if (cabecera[i].equals("Paginas")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"paginas_R-60x60.png"));
                tryAddingNode("Paginas");
            }
            if (cabecera[i].equals("Lugar")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"lugarpub_R-60x60.png"));
                tryAddingNode("Lugar");
            }
            if (cabecera[i].equals("Editorial")){
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"editorial_R-60x60.png"));
                tryAddingNode("Editorial");
            }
        }
        tablaCitas.setRowHeight(90);
        try{
        if(!nodeFormatsMap.isEmpty());
            getFormatOfCitExample();
        }catch(ArrayIndexOutOfBoundsException aioobe){
        }
    }

/**
 * Returns an example of the citation, acording with the values in the maps
 * If the respective key of the map is null, then will use the key instead the respective value
 * @return
 */
    public String getFormatOfCitExample(){
        String resultant="";
        String aux="";
        for (int i=0; i<citNodes.size();i++){
            aux=citNodes.elementAt(i).toString().substring(0, (citNodes.elementAt(i).toString().length()-1) );
            if(nodeFormatsMap.get(aux)==null){
                resultant+=( (String) citNodes.elementAt(i));
            }else{
                String temp=(String) (nodeFormatsMap.get( (String) tablaCitas.getColumnName( i ) ));
                //detectando el tipo de nodo
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Autor") ){nodeCode=1;}
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Fecha") ){nodeCode=2;}
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Titulo") ){nodeCode=3;}
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Editorial") ){nodeCode=4;}
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Lugar") ){nodeCode=5;}
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Pag") ){nodeCode=6;}
                if(((String) tablaCitas.getColumnName( i ) ).startsWith("Volumen") ){nodeCode=7;}
                if(temp!=null)
                    resultant+=( GUIRenderer.mixMsgResources(temp,GUIRenderer.messageResources(nodeCode)))+( (String) citNodes.elementAt(i)).substring( ( (String) citNodes.elementAt(i)).length()-1 );
            }//fin else
        }//fin for
        javax.swing.ToolTipManager.sharedInstance().setDismissDelay(20000);//Sets duration of tooltiptext to 20 seconds
        tablaCitas.setToolTipText(resultant);
        return resultant;
    }//fin getFormatOfCitExample

    /**
     * Adds an node element Key to nodeWeight HashMap
     * if element already exists, does nothing
     * else adds the element to the HashMap referenced to a null value
     */
     public void tryAddingNode(String keyNode){
         if (!nodeWeightMap.containsKey(keyNode)){
             nodeWeightMap.put(keyNode, null);
         }
     }

/**
 * Builds the elements by node Table
 *
 */
    public void buildNodeTable(){
        //se genera y asigna el nuevo modelo de tabla a la tabla formato de nodos
        String[][] datos=new String[1][4];
        String[] cabecera=new String[nodeFormat.size()];
        for (int i=0;i<nodeFormat.size();i++){
            cabecera[i]=nodeFormat.elementAt(i).toString().substring(0,nodeFormat.elementAt(i).toString().length() );
        }
        DefaultTableModel dtm=new DefaultTableModel(datos,cabecera);
        tablaNodos.setModel(dtm);
        //Ingresa las imagenes al modelo de la tabla
        for(int i=0;i<cabecera.length;i++){
            if (cabecera[i].equals("A")){
                if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Autor") )
                    tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"Nombre_R-60x60.png"));
                else
                    tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"Myus_R-60x60.png"));
            }
            if (cabecera[i].equals("a")){
                tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"minusculas_R-60x60.png"));
            }
            if (cabecera[i].equals("S")){
                tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"separador_R-60x60.png"));
            }
            if (cabecera[i].equals("N")){
                tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"numero_R-60x60.png"));
            }
            if (cabecera[i].equals("D")){
                tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"dia_R-60x60.png"));
            }
            if (cabecera[i].equals("Y")){
                tablaNodos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"anho_R-60x60.png"));
            }
        }
        //Muestra el ejemplo en un formato mas claro para el usuario
        nodeExampleTxt.setText( GUIRenderer.mixMsgResources(nodeExample, GUIRenderer.messageResources(nodeCode)) );
        tablaNodos.setRowHeight(90);
        tablaNodos.getTableHeader().setReorderingAllowed(false);
        tablaNodos.getTableHeader().setResizingAllowed(false);
    }

/**
 * Builds tablaElementos for being used on weight assign
 */
    public void buildElementTable(){
        //se genera y asigna el nuevo modelo de tabla a la tabla formato de nodos
        Vector nodeComponents = GUIRenderer.splitNodeFormat( (String) (nodeFormatsMap.get( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) )) );
        String[][] datos=new String[1][4];
        String[] cabecera=new String[nodeComponents.size()];
        for (int i=0;i<nodeComponents.size();i++){
            cabecera[i]=nodeComponents.elementAt(i).toString();
        }
        DefaultTableModel dtm=new DefaultTableModel(datos,cabecera);
        tablaElementos.setModel(dtm);
        //Ingresa las imagenes al modelo de la tabla
        for(int i=0;i<cabecera.length;i++){
            if (cabecera[i].equals("Mayuscula")){
                tablaElementos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"Myus_R-60x60.png"));
            }else
            if (cabecera[i].equals("minuscula")){
                tablaElementos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"minusculas_R-60x60.png"));
            }else
            if (cabecera[i].equals("Numero")){
                tablaElementos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"numero_R-60x60.png"));
            }else
            if (cabecera[i].equals("Day")){
                tablaElementos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"dia_R-60x60.png"));
            }else
            if (cabecera[i].equals("Year")){
                tablaElementos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"anho_R-60x60.png"));
            }else{
                tablaElementos.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(File.separator+"interfaz"+File.separator+"iconos"+File.separator+"separador_R-60x60.png"));
            }
        }
        tablaElementos.setRowHeight(90);
        tablaElementos.getTableHeader().setReorderingAllowed(false);
        tablaElementos.getTableHeader().setResizingAllowed(false);
    }

    private void addAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAuthorActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Autor";
            addAuthor.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
        
    }//GEN-LAST:event_addAuthorActionPerformed

    private void addDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDateActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Fecha";
            addDate.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
    }//GEN-LAST:event_addDateActionPerformed

    private void addVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVolumeActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Volumen";
            addVolume.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
    }//GEN-LAST:event_addVolumeActionPerformed

    private void addPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPageActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Paginas";
            addPage.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
    }//GEN-LAST:event_addPageActionPerformed

    private void addPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaceActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Lugar";
            addPlace.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
    }//GEN-LAST:event_addPlaceActionPerformed

    private void addPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherActionPerformed
        if (trap==false){
            trap=true;
            nodoAux="Editorial";
            //SeparadorWindow.pack();
            //SeparadorWindow.setVisible(true);
            addPublisher.setEnabled(false);
            //botonNuevoTipoCita.setEnabled(false);
            //closeControls.setEnabled(false);
            citNodes.add(nodoAux+" ");
            trap=false;
        }
    }//GEN-LAST:event_addPublisherActionPerformed

    private void botonNuevoTipoCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoTipoCitaActionPerformed
        if(nuevaCita){
            nuevaCita=false;
            nuevoTipoCitaTxt.setEnabled(true);
            botonNuevoTipoCita.setText("OK");
            closeControls.setEnabled(false);
        }
        else{
            if(true){//here: method to validation and send new citation type to control
                nuevaCita=true;
                nuevoTipoCitaTxt.setEnabled(false);
                botonNuevoTipoCita.setText("Nuevo Tipo");
                closeControls.setEnabled(true);
            }
        }
}//GEN-LAST:event_botonNuevoTipoCitaActionPerformed

    public void setNodeExampleTxt(){
        nodeFormatsMap.put( (String)(tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ), nodeExample);
        String temp=(String) (nodeFormatsMap.get( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ));
        nodeFormatExampleTxt.setText( GUIRenderer.mixMsgResources(temp,GUIRenderer.messageResources(nodeCode)) );
        if(nodeFormatExampleTxt.getText().length()<1){
            nodeFormatsMap.put( (String)(tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ), null);
        }
    }

    private void botonAddUpperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddUpperActionPerformed
        nodeFormat.add("A");
        nodeExample+="A ";
        disableAllFormatButtons();
        buildNodeTable();
        if ( (botonPredef8.getText().equals("Day") ) && !(nodeFormat.contains("D")) ){
            botonPredef8.setEnabled(true);
        }
        if ( (botonPredef9.getText().equals("Year") ) && !(nodeFormat.contains("Y")) ){
            botonPredef9.setEnabled(true);
        }
        botonAddSeparator.setEnabled(true);
}//GEN-LAST:event_botonAddUpperActionPerformed

    private void botonAddLowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddLowerActionPerformed
        nodeFormat.add("a");
        nodeExample+="a ";
        disableAllFormatButtons();
        buildNodeTable();
        if ( (botonPredef8.getText().equals("Day") ) && !(nodeFormat.contains("D")) ){
            botonPredef8.setEnabled(true);
        }
        if ( (botonPredef9.getText().equals("Year") ) && !(nodeFormat.contains("Y")) ){
            botonPredef9.setEnabled(true);
        }
        botonAddSeparator.setEnabled(true);
    }//GEN-LAST:event_botonAddLowerActionPerformed

    private void botonAddNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddNumberActionPerformed
        nodeFormat.add("N");
        nodeExample+="N ";
        disableAllFormatButtons();
        buildNodeTable();
        if ( (botonPredef8.getText().equals("Day") ) && !(nodeFormat.contains("D")) ){
            botonPredef8.setEnabled(true);
        }
        if ( (botonPredef9.getText().equals("Year") ) && !(nodeFormat.contains("Y")) ){
            botonPredef9.setEnabled(true);
        }
        botonAddSeparator.setEnabled(true);
    }//GEN-LAST:event_botonAddNumberActionPerformed

    private void botonAddSeparatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddSeparatorActionPerformed
        nodeFormat.add("S");
        formatFlag=true;
        SeparadorWindow.pack();
        SeparadorWindow.setVisible(true);
    }//GEN-LAST:event_botonAddSeparatorActionPerformed

    private void botonPredef8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPredef8ActionPerformed
        if ( (botonPredef8.getText().equals("Day") ) && !(nodeFormat.contains("D")) ){
            botonPredef8.setEnabled(false);
            nodeFormat.add("D");
            nodeExample+="D ";
            buildNodeTable();
            return;
        }
        ReglasPorNodoWindow.setVisible(false);
        nodeExample= ( (String) msgRsrcButtons.elementAt(20) );
        setNodeExampleTxt();
    }//GEN-LAST:event_botonPredef8ActionPerformed

    private void botonPredef9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPredef9ActionPerformed
        if ( (botonPredef9.getText().equals("Year") ) && !(nodeFormat.contains("Y")) ){
            botonPredef9.setEnabled(false);
            nodeFormat.add("Y");
            nodeExample+="Y ";
            buildNodeTable();
            return;
        }
        ReglasPorNodoWindow.setVisible(false);
        nodeExample= ( (String) msgRsrcButtons.elementAt(22) );
        setNodeExampleTxt();
    }//GEN-LAST:event_botonPredef9ActionPerformed
   
    private void botonOKPesosParaNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOKPesosParaNodoActionPerformed
        try{
            PesosParaNodoWindow.setVisible(false);
            if( Integer.parseInt(pesoTotalTxt.getText() )==100){
                nodeWeightMap.put(tablaCitas.getColumnName(tablaCitas.getSelectedColumn()), nodeWeight);//almacena en el hashmap el vector de pesos del nodo
                    nodeFormatExampleTxt.setForeground(Color.black);
            }
            else{
                nodeWeightMap.put(tablaCitas.getColumnName(tablaCitas.getSelectedColumn()), lastWeight);//almacena en el hashmap el vector de pesos del nodo inicial
            }
            botonReglasOK.setEnabled(true);
        }catch(NumberFormatException e){
        }
    }//GEN-LAST:event_botonOKPesosParaNodoActionPerformed

    private void tablaCitasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCitasMouseReleased
        PesosParaNodoWindow.setVisible(false);
        ReglasPorNodoWindow.setVisible(false);
        labelErrorCita.setVisible(false);
System.out.println("tablaCitasClick - boton: "+evt.getButton());
    try{
        if ((evt.getClickCount()==2) &&(evt.getButton()==MouseEvent.BUTTON1) ){//DOBLE CLICK PARA EDITAR EL ELEMENTO
        msgRsrcButtons=new Vector();
        //ajustando la vista y habilitando botones necesarios
        nodeFormat=new Vector();
        nodeExampleTxt.setText("");
        nodeExample="";
        buildNodeTable();
        botonAddSeparator.setEnabled(true);
        botonAddUpper.setEnabled(true);
        botonAddLower.setEnabled(true);
        botonAddNumber.setEnabled(true);
        botonPredef8.setEnabled(true);
        botonPredef9.setEnabled(true);
        botonAddNumber.setVisible(true);
        //detectando el tipo de nodo
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Autor") ){nodeCode=1;}
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Fecha") ){nodeCode=2;}
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Titulo") ){nodeCode=3;}
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Editorial") ){nodeCode=4;}
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Lugar") ){nodeCode=5;}
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Pag") ){nodeCode=6;}
        if(((String) tablaCitas.getColumnName(tablaCitas.getSelectedColumn())).startsWith("Volumen") ){nodeCode=7;}
        //Obtiene los mensajes propios del nodo seleccionado
        msgRsrcButtons=GUIRenderer.messageResources(nodeCode);
        //Asigna las etiquetas a su boton correspondiente
        if (nodeCode==2){
            botonPredef8.setText("Day");
            botonPredef9.setText("Year");
        }else{
            botonPredef8.setText("");
            botonPredef9.setText("");
        }
        if ( (botonPredef8.getText().equals("Day")) && (botonPredef9.getText().equals("Year"))){
            botonPredef8.setVisible(true);
            botonPredef9.setVisible(true);
        }else{
            botonPredef8.setVisible(false);
            botonPredef9.setVisible(false);
        }
        //Deshabilitar addNumero si el nodo es una fecha, lugar o nombre
        if( (nodeCode==1) ||(nodeCode==5) || (nodeCode==2) ){
            botonAddNumber.setVisible(false);
        }
        //Deshabilitar addLower si el nodo es un lugar o nombre
        if( (nodeCode==1) ||(nodeCode==5)){
            botonAddLower.setVisible(false);
        }else
            botonAddLower.setVisible(true);
        ReglasPorNodoWindow.setTitle("Modificando: "+ tablaCitas.getColumnName(tablaCitas.getSelectedColumn()) );
        ReglasPorNodoWindow.pack();
        ReglasPorNodoWindow.setVisible(true);
        tablaCitas.getCellEditor().cancelCellEditing();
        }// FIN DOBLE CLICK
//**************************************** CLICK! ********************************************************
        if ( (evt.getClickCount()==1)&&(evt.getButton()==MouseEvent.BUTTON1)){
            String temp=(String) (nodeFormatsMap.get( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ));
            //detectando el tipo de nodo
            if( ( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Autor") ){
                nodeCode=1;
            }
            if( ( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Fecha") ){
                nodeCode=2;
            }
            if( ( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Titulo") ){
                nodeCode=3;
            }
            if( (  (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Editorial") ){
                nodeCode=4;
            }
            if( ( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Lugar") ){
                nodeCode=5;
            }
            if( ( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Pag") ){
                nodeCode=6;
            }
            if( ( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) ).startsWith("Volumen") ){
                nodeCode=7;
            }
            nodeFormatExampleTxt.setText("");
            if(temp!=null){
                nodeFormatExampleTxt.setText( GUIRenderer.mixMsgResources(temp,GUIRenderer.messageResources(nodeCode)) );
            }
            if (nodeFormatExampleTxt.getText().equals("")){
                PesosParaNodoWindow.setVisible(false);
            }
            //Checking if the selected node has assigned Weight Values
            if (nodeWeightMap.get(tablaCitas.getColumnName(tablaCitas.getSelectedColumn()))!=null ){
                nodeFormatExampleTxt.setForeground(Color.black);
            }else{
                nodeFormatExampleTxt.setForeground(Color.red);
            }
        }//FIN UN SOLO CLICK
//*********************************** RIGHT CLICK! ***************************************************************
        if(evt.getButton()==MouseEvent.BUTTON3){
            //rebuilding citTable
            Vector citAux=new Vector();
            if (citNodes.size()==tablaCitas.getColumnCount())
                for (int i=0; i<citNodes.size();i++){
                    for(int j=0;j<citNodes.size();j++){
                        if(  ((String)citNodes.elementAt(j)).startsWith(tablaCitas.getColumnName(i))){
                                citAux.add(citNodes.elementAt(j));
                                break;
                        }
                    }
                }
            citNodes=citAux;
            buildCitTable();
            //se llama a selectedType & selectedFormat para los tipos y formatos correspondientes
            //ademas de una bandera para controlar si es actualizacion o nuevo

            

            //llamada a createTemplate para su guardado

            //if (true){ //Llamada a metodo de control - saveCitationTemplate returns true, false
            if (GUIRenderer.saveCitationTemplate( GUIRenderer.createTemplateForSaving(citNodes,( (String) comboFormato.getSelectedItem()) , GUIRenderer.createType( ((String)comboTipo.getSelectedItem()) )) )){
                labelErrorCita.setForeground(Color.BLACK);
                labelErrorCita.setText("Los cambios se han almacenado satisfactioramente");
                labelErrorCita.setVisible(true);
                comboTipo.setEnabled(true);
                comboFormato.setEnabled(true);
            }
            else{
                labelErrorCita.setForeground(Color.RED);
                labelErrorCita.setText("Ocurrio un error al guardar los cambios");
                labelErrorCita.setVisible(true);
                comboTipo.setEnabled(true);
                comboFormato.setEnabled(true);
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }//GEN-LAST:event_tablaCitasMouseReleased

    private void comboFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFormatoActionPerformed
        selectedType=(String)comboTipo.getSelectedItem();
        selectedFormat=(String)comboFormato.getSelectedItem();
        //llamada a control - metodo que devuelva el template en forma de String - getDefinedCitationString()
        //el metodo debera recibir tipo de medio y formato de cita
//GUIRenderer.showTemplates();
        //citNodes= GUIRenderer.splitDefinedCitation(getDefinedCitationString());
        citNodes= GUIRenderer.splitDefinedCitation(GUIRenderer.getDefinedCitationString( GUIRenderer.getTemplate( ((String)comboFormato.getSelectedItem()), GUIRenderer.createType((String)comboTipo.getSelectedItem() )) ));
        buildCitTable();
        nodeFormatExampleTxt.setText("");
        if(getDefinedCitationMaps()){
            tablaCitas.setToolTipText(getFormatOfCitExample() );
            return;
        }else
            nodeFormatsMap.clear();//limpia los formatos si no hay un valor precargado
    }//GEN-LAST:event_comboFormatoActionPerformed

    private void menuItemKBTitulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKBTitulosActionPerformed
        try{
            LinkedList lista = control.retrieveAllTitles();
            this.listaDeEntidades.setListData(lista.toArray());
            this.KBWindow.setTitle("Titulos");
            this.KBWindow.pack();
            this.KBWindow.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "La configuración del servidor no es correcta,\nrevise las preferencias en el menu 'edit'.");
        }

    }//GEN-LAST:event_menuItemKBTitulosActionPerformed

    private void menuItemKBLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKBLugaresActionPerformed
        try{
            LinkedList<Location> lista = control.retrieveAllLocations();
            this.listaDeEntidades.setListData(lista.toArray());
            this.KBWindow.setTitle("Lugares");
            this.KBWindow.pack();
            this.KBWindow.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "La configuración del servidor no es correcta,\nrevise las preferencias en el menu 'edit'.");
        }

    }//GEN-LAST:event_menuItemKBLugaresActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        if(this.KBWindow.getTitle().equals("Editoriales")){
            this.AgregarWindow.setTitle("Agregar Editorial");
            this.AgregarWindow.pack();
            etiqueta.setText("Editorial :");
            this.AgregarWindow.setVisible(true);
        }else{
            if(this.KBWindow.getTitle().equals("Titulos")){
                this.AgregarWindow.setTitle("Agregar Titulo");
                this.AgregarWindow.pack();
                etiqueta.setText("Titulo :");
                this.AgregarWindow.setVisible(true);
            }else{
                if(this.KBWindow.getTitle().equals("Lugares")){
                    this.AgregarWindow.setTitle("Agregar Lugar");
                    this.AgregarWindow.pack();
                    etiqueta.setText("Lugar :");
                    this.AgregarWindow.setVisible(true);
                }else{
                    this.AgregarWindow.setTitle("Agregar Autor");
                    this.AgregarWindow.pack();
                    etiqueta.setText("Nombre/Apellido :");
                    this.AgregarWindow.setVisible(true);
                }
            }
        }
}//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        String valueSelected = (String) this.listaDeEntidades.getSelectedValue();

        if(KBWindow.getTitle().equals("Editoriales")){
            control.deletePublisher(valueSelected);
            LinkedList listaEditoriales = control.retrieveAllPublishers();
            this.listaDeEntidades.setListData(listaEditoriales.toArray());
        }else{
            if(KBWindow.getTitle().equals("Autores")){
                control.deleteAuthor(valueSelected);
                LinkedList listaAutores = control.retrieveAllAuthors();
                this.listaDeEntidades.setListData(listaAutores.toArray());
            }else{
                if(KBWindow.getTitle().equals("Titulos")){
                    control.deleteTitle(valueSelected);
                    LinkedList listaTitulos = control.retrieveAllTitles();
                    this.listaDeEntidades.setListData(listaTitulos.toArray());
                }else{
                    control.deleteLocation(valueSelected);
                    LinkedList listaLugares = control.retrieveAllLocations();
                    this.listaDeEntidades.setListData(listaLugares.toArray());
                }
            }
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        String value = TextFieldAgregar.getText();
        if(AgregarWindow.getTitle().equals("Agregar Editorial")){

            if(TextFieldAgregar.getText().equals("")){
                JOptionPane.showMessageDialog(this, "El registro esta vacio");
            }else{
                control.savePublisher(value);
                JOptionPane.showMessageDialog(this, "El registro se guardo correctamente");
                TextFieldAgregar.setText("");
                AgregarWindow.setVisible(false);
                LinkedList listaEditoriales = control.retrieveAllPublishers();
                this.listaDeEntidades.setListData(listaEditoriales.toArray());
            }

        }

        if(AgregarWindow.getTitle().equals("Agregar Titulo")){

                if(TextFieldAgregar.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "El registro esta vacio");
                }else{
                    control.saveTitle(value);
                    JOptionPane.showMessageDialog(this, "El registro se guardo correctamente");
                    TextFieldAgregar.setText("");
                    AgregarWindow.setVisible(false);
                    LinkedList listaTitulos = control.retrieveAllTitles();
                    this.listaDeEntidades.setListData(listaTitulos.toArray());
                }

            }

        if(AgregarWindow.getTitle().equals("Agregar Autor")){

                    if(TextFieldAgregar.getText().equals("")){
                        JOptionPane.showMessageDialog(this, "El registro esta vacio");
                    }else{
                        control.saveAuthor(value);
                        JOptionPane.showMessageDialog(this, "El registro se guardo correctamente");
                        TextFieldAgregar.setText("");
                        AgregarWindow.setVisible(false);
                        LinkedList listaAutores = control.retrieveAllAuthors();
                        this.listaDeEntidades.setListData(listaAutores.toArray());
                    }

        }

        if(AgregarWindow.getTitle().equals("Agregar Lugar")){
            if(TextFieldAgregar.getText().equals("")){
                        JOptionPane.showMessageDialog(this, "El registro esta vacio");
            }else{
                        control.saveLocation(value);
                        JOptionPane.showMessageDialog(this, "El registro se guardo correctamente");
                        TextFieldAgregar.setText("");
                        AgregarWindow.setVisible(false);
                        LinkedList listaLugares = control.retrieveAllLocations();
                        this.listaDeEntidades.setListData(listaLugares.toArray());
                    }
                }
            
        
    }//GEN-LAST:event_BotonGuardarActionPerformed
    /**
     * Calculates the total weight of elements in the current node
     */
    public void calculeTotalWeight(){
        int total=0;
        for (int i=0; i<nodeWeight.size();i++){
            total+= Integer.parseInt( String.valueOf( nodeWeight.elementAt(i)) );
        }
        pesoTotalTxt.setText(String.valueOf(total) );
    }

    private void pesoElemNodoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoElemNodoTxtActionPerformed
        try{
            if(Integer.parseInt(pesoElemNodoTxt.getText())>100){
                pesoElemNodoTxt.setText("");
                return;
            }else
            if(!(Integer.parseInt(pesoElemNodoTxt.getText())>100-(nodeWeight.size()-1)) &&!( (Integer.parseInt(pesoTotalTxt.getText())+(Integer.parseInt(pesoElemNodoTxt.getText()))-(Integer.parseInt( String.valueOf( nodeWeight.elementAt(tablaElementos.getSelectedColumn())))))>100 ))
                nodeWeight.setElementAt( Integer.parseInt(pesoElemNodoTxt.getText()) , tablaElementos.getSelectedColumn());
            else
                pesoElemNodoTxt.setText("");
            calculeTotalWeight();
        }catch(ArrayIndexOutOfBoundsException e){
        }catch(NumberFormatException e){
            pesoElemNodoTxt.setText("");
        }
    }//GEN-LAST:event_pesoElemNodoTxtActionPerformed

    private void tablaElementosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaElementosMouseReleased
        try{
//System.out.println("nodeWeight tabElem -mouse: "+nodeWeight);
//System.out.println("selectedcolumn tabElem -mouse: "+tablaElementos.getSelectedColumn());
            pesoElemNodoTxt.setText( String.valueOf(nodeWeight.elementAt( tablaElementos.getSelectedColumn() ) ) );
            selectedElementLabel.setText(tablaElementos.getColumnName(tablaElementos.getSelectedColumn()));
            calculeTotalWeight();
        }catch(ArrayIndexOutOfBoundsException e){
        }
    }//GEN-LAST:event_tablaElementosMouseReleased


    public void cargarPesos(){
        try{
            Vector nodeComponents = GUIRenderer.splitNodeFormat( (String) (nodeFormatsMap.get( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) )) );
            if (nodeComponents==null)
                return;
            if (nodeComponents.size()==0)
                return;
            nodeWeight=new Vector();
            if(nodeWeightMap.get(tablaCitas.getColumnName(tablaCitas.getSelectedColumn()))==null ){
                for (int i=0; i<nodeComponents.size(); i++){
                    nodeWeight.add(0);//se crea un valor para cada componente del nodo
                    lastWeight=null;//no existen pesos anteriores
                }
            }else{
                lastWeight=new Vector();
                nodeWeight= ((Vector)nodeWeightMap.get(tablaCitas.getColumnName(tablaCitas.getSelectedColumn())));
                for (int i=0; i<nodeWeight.size();i++){
                    lastWeight.add(nodeWeight.elementAt(i));
                }
            }
            buildElementTable();
            pesoTotalTxt.setText("");
            pesoElemNodoTxt.setText("");
            selectedElementLabel.setText("<Ninguno>");
            PesosParaNodoWindow.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void botonPesosDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPesosDefectoActionPerformed
        int result;
        try{
            result=100/(nodeWeight.size());
                for(int i=0; i<nodeWeight.size();i++){
                    nodeWeight.setElementAt(result, i);
                }
        }catch(ArithmeticException e){
        }
        calculeTotalWeight();

    }//GEN-LAST:event_botonPesosDefectoActionPerformed

    private void citasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_citasComponentShown
        currentPage=0;
        this.previewsButtonFoundReferences.setEnabled(false);
        if(this.listaDeCitas.size()==0){
            JOptionPane.showMessageDialog(this,"<html>No has selecionado ninguna referencia. Favor de regresar a la pasta&ntilde;a anterior y seleccionar al menos una!</html>","El raton se callo de la rueda",JOptionPane.WARNING_MESSAGE);
            temporalReferences=new LinkedList<modelo.TemporalReference>();
            cleanGUI();
        }else{
            System.out.println("Se buscara usando el patron: "+this.typeOfCitationCombo.getSelectedItem().toString());
            this.temporalReferences = this.control.findCitations(this.listaDeCitas, this.typeOfCitationCombo.getSelectedItem().toString());
            this.counterLabelFoundReferences.setText(currentPage+1+"/"+temporalReferences.size());
            this.originalReferenceTextArea.setText(temporalReferences.getFirst().getOriginalReference());
            if(temporalReferences != null){
                //System.out.println("TIPO: "+temporalReferences.getFirst().getType().toString());
                //System.out.println("no Cita: "+currentPage);
                //System.out.println("TIPO: "+temporalReferences.get(currentPage).getType().toString());
                this.comboTipoFoundReferences.setSelectedItem(temporalReferences.getFirst().getType().toString());
                this.comboSoporteReferences.setSelectedItem(temporalReferences.getFirst().getSoporte().toString());

                String autores = "";
                int listSize = temporalReferences.getFirst().getAutors().size();
                int i=0;
                if(listSize==1)
                    autores = temporalReferences.getFirst().getAutors().getFirst().getName();
                else{
                    for(modelo.Author a : temporalReferences.getFirst().getAutors()){
                        if(i!=listSize)
                            autores += a.getName() +", ";
                        else
                            autores += a.getName();
                        i++;
                    }
                }

                if(temporalReferences.getFirst().getAutors()!=null)
                    this.authorFoundReferencesTextArea.setText(autores);
                if(temporalReferences.getFirst().getTitle()!=null)
                    this.titleFoundReferencesTextField.setText(temporalReferences.getFirst().getTitle().toString());
                if(temporalReferences.getFirst().getDate()!= null)
                    this.dateFoundReferencesTextField.setText(temporalReferences.getFirst().getDate().getDateWithStatement());
                if(temporalReferences.getFirst().getExtra()!=null)
                    this.extraFoundReferencesTextArea.setText(temporalReferences.getFirst().getExtra());
                if(temporalReferences.getFirst().getLocation() != null)
                    this.locationFoundReferencesTextField.setText(temporalReferences.getFirst().getLocation().toString());
                if(temporalReferences.getFirst().getPublisher() != null)
                    this.publisherFoundReferencesTextField.setText(temporalReferences.getFirst().getPublisher().toString());
                if(temporalReferences.getFirst().getPages() != null)
                    this.pagesFoundReferencesTextField.setText(temporalReferences.getFirst().getPages().toString());
                if(temporalReferences.getFirst().getVolume()!= null)
                    this.volumeFoundReferencesteTextField.setText(temporalReferences.getFirst().getVolume().toString());
            }

        }

    }//GEN-LAST:event_citasComponentShown

    private void botonNuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaCitaActionPerformed
        addAuthor.setEnabled(true);
        addDate.setEnabled(true);
        addTitle.setEnabled(true);
        addPlace.setEnabled(true);
        addVolume.setEnabled(true);
        addPage.setEnabled(true);
        addPublisher.setEnabled(true);
        FormatoCitaWindow.pack();
        FormatoCitaWindow.setVisible(true);
        citNodes=new Vector();
        nodeWeightMap.clear();
        nodeFormatsMap.clear();
        nodeFormatExampleTxt.setText("");
    }//GEN-LAST:event_botonNuevaCitaActionPerformed

    private void nodeFormatExampleTxtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nodeFormatExampleTxtMouseReleased
        if ( (evt.getClickCount()==2)  && (nodeFormatExampleTxt.getText().length()>0) )
                try{
                    Vector nodeComponents = GUIRenderer.splitNodeFormat( (String) (nodeFormatsMap.get( (String) tablaCitas.getColumnName( tablaCitas.getSelectedColumn() ) )) );
                    if (nodeComponents==null)
                        return;
                    nodeWeight=new Vector();
                    if(nodeWeightMap.get(tablaCitas.getColumnName(tablaCitas.getSelectedColumn()))==null ){
                        for (int i=0; i<nodeComponents.size(); i++){
                            nodeWeight.add(0);//se crea un valor para cada componente del nodo
                            lastWeight=null;//no existen pesos anteriores
                        }
                    }else{
                        lastWeight=new Vector();
                        nodeWeight= ((Vector)nodeWeightMap.get(tablaCitas.getColumnName(tablaCitas.getSelectedColumn())));
                        for (int i=0; i<nodeWeight.size();i++){
                            lastWeight.add(nodeWeight.elementAt(i));
                        }
                    }//fin else
                    buildElementTable();
                    pesoTotalTxt.setText("");
                    pesoElemNodoTxt.setText("");
                    selectedElementLabel.setText("<Ninguno>");
                    calculeTotalWeight();
                    PesosParaNodoWindow.pack();
                    PesosParaNodoWindow.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }//fin catch

    }//GEN-LAST:event_nodeFormatExampleTxtMouseReleased

    private void MenuItemPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemPreferenciasActionPerformed
        OswaReader reader = new OswaReader();
        this.ConfigWindow.setTitle("Preferencias");
        this.ConfigWindow.pack();
        TextFieldHost.setText(reader.getPropiedad("HOST"));
        TextFieldPort.setText(reader.getPropiedad("PORT"));
        TextFieldUser.setText(reader.getPropiedad("USER"));
        PasswordFieldPass.setText(reader.getPropiedad("PASS"));
        this.GuardarConfig.setEnabled(false);
        this.ConfigWindow.setVisible(true);
        
    }//GEN-LAST:event_MenuItemPreferenciasActionPerformed

    private void GuardarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarConfigActionPerformed
        //OswaReader reader = new OswaReader();
        String user = TextFieldUser.getText();
        String host = TextFieldHost.getText();
        String port = TextFieldPort.getText();
        String pass = PasswordFieldPass.getText();
        
        if(TextFieldUser.isEditable()){
            OswaReader reader=new OswaReader();
                String cambios = host+","+port+","+user+","+pass;
                reader.saveConfig(cambios);
                this.GuardarConfig.setEnabled(false);           
        }else{
            JOptionPane.showMessageDialog(this, "No se ha guardado nada");
        }            
        
    }//GEN-LAST:event_GuardarConfigActionPerformed

    private void BotonSalirConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirConfigActionPerformed
        this.ConfigWindow.setVisible(false);
    }//GEN-LAST:event_BotonSalirConfigActionPerformed

    private void BotonSalirKBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirKBActionPerformed
        this.KBWindow.show(false);
    }//GEN-LAST:event_BotonSalirKBActionPerformed

    private void ConfigWindowComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ConfigWindowComponentShown
            TextFieldUser.getDocument().addDocumentListener(new DocumentListener(){

                public void insertUpdate(DocumentEvent e) {
                    GuardarConfig.setEnabled(true);
                }

                public void removeUpdate(DocumentEvent e) {
                    GuardarConfig.setEnabled(true);
                }

                public void changedUpdate(DocumentEvent e) {
                    GuardarConfig.setEnabled(true);
                }

            });
            TextFieldHost.getDocument().addDocumentListener(new DocumentListener(){

            public void insertUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            public void removeUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            public void changedUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            });
            TextFieldPort.getDocument().addDocumentListener(new DocumentListener(){

            public void insertUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            public void removeUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            public void changedUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            });
            PasswordFieldPass.getDocument().addDocumentListener(new DocumentListener(){

            public void insertUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            public void removeUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            public void changedUpdate(DocumentEvent e) {
                GuardarConfig.setEnabled(true);
            }

            });
        
    }//GEN-LAST:event_ConfigWindowComponentShown

    private void newCitationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCitationActionPerformed
        String selectedText = this.textPaneReferencias.getSelectedText();
        this.listaDeCitas.add(selectedText);
        LouhiHighlighter lh = new LouhiHighlighter(this.textPaneReferencias);
        lh.search(selectedText);

    }//GEN-LAST:event_newCitationActionPerformed

    private void clearButtonReferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonReferenciasActionPerformed
        this.listaDeCitas = new LinkedList<String>();
        LouhiHighlighter lh = new LouhiHighlighter(this.textPaneReferencias);
        lh.clearHightlight();
    }//GEN-LAST:event_clearButtonReferenciasActionPerformed

    private void botonReglasOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReglasOKActionPerformed
        ReglasPorNodoWindow.setVisible(false);
        setNodeExampleTxt();
        nodeWeightMap.put(tablaCitas.getColumnName(tablaCitas.getSelectedColumn()), null);
        cargarPesos();
        getFormatOfCitExample();
}//GEN-LAST:event_botonReglasOKActionPerformed

    private void nextButtonfoundReferences(java.awt.event.ActionEvent evt){
        if(temporalReferences.size()==0){
            return;
        }

        this.previewsButtonFoundReferences.setEnabled(true);
        //we save the changes form the current thing
                saveChanges(temporalReferences.get(currentPage));
        //then we move to the next page
        currentPage++;
        if(currentPage <= temporalReferences.size()-1 ){
            cleanGUI();
            modelo.TemporalReference tr = temporalReferences.get(currentPage);
            if(tr != null){
                


                //pasamos a la siguiente pagina
                this.cleanGUI();
                System.out.println("Fue loosser reference: "+tr.isIsLooserReference());
                this.counterLabelFoundReferences.setText(currentPage+1+"/"+temporalReferences.size());
                this.originalReferenceTextArea.setText(tr.getOriginalReference());
                //rellenamos el combo con su repectivo tipo
                //System.out.println("no Cita: "+currentPage);
                //System.out.println("TIPO: "+temporalReferences.get(currentPage).getType().toString());
                this.comboTipoFoundReferences.setSelectedItem(temporalReferences.get(currentPage).getType().toString());
                this.comboSoporteReferences.setSelectedItem(temporalReferences.get(currentPage).getSoporte().toString());
                String autores = "";
                //we first see if there is a list
                if (tr.getAutors() != null) {
                    int listSize = tr.getAutors().size();
                    int i = 0;
                    if (listSize == 1) {
                        autores = tr.getAutors().getFirst().getName();
                    } else {
                        for (modelo.Author a : tr.getAutors()) {
                            i++;
                            if (listSize != i) {
                                autores += a.getName() + ", ";
                            } else {
                                autores += a.getName();
                            }

                        }
                    }
                }
                if(tr.getAutors()!=null)
                    this.authorFoundReferencesTextArea.setText(autores);
                if(tr.getTitle()!=null)
                    this.titleFoundReferencesTextField.setText(tr.getTitle().toString());
                if(tr.getDate()!= null)
                    this.dateFoundReferencesTextField.setText(tr.getDate().getDateWithStatement());
                if(tr.getExtra()!=null)
                    this.extraFoundReferencesTextArea.setText(tr.getExtra());
                if(tr.getLocation() != null)
                    this.locationFoundReferencesTextField.setText(tr.getLocation().toString());
                if(tr.getPublisher() != null)
                    this.publisherFoundReferencesTextField.setText(tr.getPublisher().toString());
                if(tr.getPages() != null)
                    this.pagesFoundReferencesTextField.setText(tr.getPages().toString());
                if(tr.getVolume()!= null)
                    this.volumeFoundReferencesteTextField.setText(tr.getVolume().toString());
                if(tr.getPeriodicalTitle() != null)
                    this.magazineFoundReferencesTextField.setText(tr.getPeriodicalTitle().toString());
                if(tr.getIssn() != null)
                    this.issnFoundReferencesTextField.setText(tr.getIssn());
                if(tr.getIsbn() != null)
                    this.isbnFoundReferencesTextField.setText(tr.getIsbn());
                if(tr.getInstitution() != null)
                    this.institutionTextField.setText(tr.getInstitution().toString());
                if(tr.getUrl() != null)
                    this.urlTextField.setText(tr.getUrl().toString());
                if(tr.getNumber() != null)
                    this.numberTextField.setText(tr.getNumber().toString());
            }
        }else{

            for(modelo.TemporalReference aTR : temporalReferences){
                //guardamos el id del articulo
                
                aTR.setArticleID(articleID);
                aTR.setIdRevOrigen(this.getSelectedMagazineID());
                int nacional = control.isNacional((String)this.comboRevistasMetadata.getSelectedItem(),aTR.getLocation().getNameOfLocation());
                int autocita = control.autocitationCheck(aTR.getPeriodicalTitle().getName() , (String)this.comboRevistasMetadata.getSelectedItem());
                if(nacional == 1)
                    aTR.setIsNacional(true);
                else{
                    int n = JOptionPane.showConfirmDialog(this,
                                "Lohi no sabe si '"+aTR.getLocation().getNameOfLocation() +"' es nacional, lo es?",
                                "Es nacional?",
                                 JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION)
                        aTR.setIsNacional(true);
                    else
                        aTR.setIsNacional(false);
                }

                if(autocita == 1)
                    aTR.setClasificacion(Clasificacion.AUTOCITA);
                else{
                    int n = JOptionPane.showConfirmDialog(this,
                                "Lohi no sabe si '"+aTR.getPeriodicalTitle().getName()+" vs "+(String)this.comboRevistasMetadata.getSelectedItem()+"' es autocita, lo es?",
                                "Es autocita?",
                                 JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION)
                       aTR.setClasificacion(Clasificacion.AUTOCITA);
                    else
                        aTR.setClasificacion(Clasificacion.NOAUTOCITA);
                }
            }
          
            revWin.setCitationList(temporalReferences);
            revWin.setVisible(true);
            currentPage=temporalReferences.size()-1;
        }
    }

    public void saveChanges(modelo.TemporalReference tr) {
            String author = this.authorFoundReferencesTextArea.getText();
            String title = this.titleFoundReferencesTextField.getText();
            String date = this.dateFoundReferencesTextField.getText();
            String extra = this.extraFoundReferencesTextArea.getText();
            String location = this.locationFoundReferencesTextField.getText();
            String publisher = this.publisherFoundReferencesTextField.getText();
            String pages = this.pagesFoundReferencesTextField.getText();
            String volume = this.volumeFoundReferencesteTextField.getText();
            String periodicalTitle = this.magazineFoundReferencesTextField.getText();
            String issn=this.issnFoundReferencesTextField.getText();
            String isbn=this.isbnFoundReferencesTextField.getText();
            String originalCitation=this.originalReferenceTextArea.getText();
            String institution=this.institutionTextField.getText();
            String url=this.urlTextField.getText();
            String number=this.numberTextField.getText();
            //Separamos y tomamos a los autores
            String []probableAuthors = this.authorFoundReferencesTextArea.getText().split("[,]");
            LinkedList<Author> listaAutoresNueva = new LinkedList<Author>();
            for(String a : probableAuthors){
                Author newAuthor = new Author(a);
                listaAutoresNueva.add(newAuthor);
            }
            tr.setAuthors(listaAutoresNueva);
            
            //metodo para preparar una fecha
            if(date != null){
                modelo.Date aDate = new modelo.Date(date);
                tr.setDate(aDate);
            }

            if(title != null)
                tr.getTitle().setATitle(title);
            if(extra != null)
                tr.setExtra(extra);
            if(location != null)
                tr.getLocation().setNameOfLocation(location);
            if(publisher != null){
                System.out.println("EL PUBLISHER TIENE: " + publisher);
                tr.getPublisher().setName(publisher);
            }
            if(pages != null)
                tr.getPages().setPages(pages);
            if(volume != null)
                tr.getVolume().setVolume(volume);
            if(periodicalTitle != null)
                tr.getPeriodicalTitle().setName(periodicalTitle);
            if(institution != null)
                tr.getInstitution().setName(institution);
            if(url != null)
                tr.getUrl().setUrl(url);
            if(number != null)
                tr.getNumber().setNumber(number);
            //guardamos los cambios que hallamos hecho en el combotipofounrference
            modelo.Type valueType = null;
            Type [] posibleTipo=valueType.values();
            String typeSelected = this.comboTipoFoundReferences.getSelectedItem().toString();
            for(int i=0;i<posibleTipo.length;i++){
                String type = posibleTipo[i].toString();
                if(typeSelected.equals(type))
                    tr.setType(posibleTipo[i]);
            }

             //guardamos los cambios que se hallan hecho en el comboSoporteReference
            modelo.SoporteEnum valueSoporte = null;
            SoporteEnum[] posibleSoporte = valueSoporte.values();
            String soporteSelected = this.comboSoporteReferences.getSelectedItem().toString();
            for (int i=0;i<posibleSoporte.length;i++){
                String soport = posibleSoporte[i].toString();
                if(soporteSelected.equals(soport))
                    tr.setSoporte(posibleSoporte[i]);
            }


            tr.setIssn(issn);
            tr.setIsbn(isbn);
            tr.setOriginalCitation(originalCitation);
            

    }


    private void previewsButtonFoundReferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewsButtonFoundReferencesActionPerformed
        //we save the changes form the current thing
                saveChanges(temporalReferences.get(currentPage));
        //then we move to the previous page
        currentPage--;
        if(currentPage == 0)
            this.previewsButtonFoundReferences.setEnabled(false);//to prevent going to page 0
        if(currentPage >= 0 ){
            cleanGUI();
            modelo.TemporalReference tr = temporalReferences.get(currentPage);
            if(tr != null){
                this.cleanGUI();
                System.out.println("Fue loosser reference: "+tr.isIsLooserReference());
                this.counterLabelFoundReferences.setText(currentPage+1+"/"+temporalReferences.size());
                this.originalReferenceTextArea.setText(tr.getOriginalReference());
                //rellenamos el combo con su respectivo tipo
                //System.out.println("no Cita: "+currentPage);
                //System.out.println("TIPO: "+temporalReferences.get(currentPage).getType().toString());
                this.comboTipoFoundReferences.setSelectedItem(temporalReferences.get(currentPage).getType().toString());
                this.comboSoporteReferences.setSelectedItem(temporalReferences.get(currentPage).getSoporte().toString());

                String autores = "";
                int listSize = tr.getAutors().size();
                int i = 0;
                if(listSize == 1)
                    autores = tr.getAutors().getFirst().getName();
                else{
                    for(modelo.Author a : tr.getAutors()){
                        i++;
                        if(listSize != i)
                            autores += a.getName() +", ";
                        else
                            autores += a.getName();
                        
                    }
                }



                if(tr.getAutors()!=null)
                    this.authorFoundReferencesTextArea.setText(autores);
                if(tr.getTitle()!=null)
                    this.titleFoundReferencesTextField.setText(tr.getTitle().toString());
                if(tr.getDate()!= null)
                    this.dateFoundReferencesTextField.setText(tr.getDate().getDateWithStatement());
                if(tr.getExtra()!=null)
                    this.extraFoundReferencesTextArea.setText(tr.getExtra());
                if(tr.getLocation() != null)
                    this.locationFoundReferencesTextField.setText(tr.getLocation().toString());
                if(tr.getPublisher() != null)
                    this.publisherFoundReferencesTextField.setText(tr.getPublisher().toString());
                if(tr.getPages() != null)
                    this.pagesFoundReferencesTextField.setText(tr.getPages().toString());
                if(tr.getVolume()!= null)
                    this.volumeFoundReferencesteTextField.setText(tr.getVolume().toString());
                if(tr.getPeriodicalTitle() != null)
                    this.magazineFoundReferencesTextField.setText(tr.getPublisher().toString());
                if(tr.getIssn() != null)
                    this.issnFoundReferencesTextField.setText(tr.getIssn());
                if(tr.getIsbn() != null)
                    this.isbnFoundReferencesTextField.setText(tr.getIsbn());
                if(tr.getInstitution() != null)
                    this.institutionTextField.setText(tr.getInstitution().toString());
                if(tr.getUrl() != null)
                    this.urlTextField.setText(tr.getUrl().toString());
                if(tr.getNumber() != null)
                    this.numberTextField.setText(tr.getNumber().toString());
            }
        }else{
            this.previewsButtonFoundReferences.setEnabled(false);
            currentPage=0;
        }
    }//GEN-LAST:event_previewsButtonFoundReferencesActionPerformed

    /**
     * Returns teh selected magazine's ID
     * @return
     */
    private long getSelectedMagazineID(){
        String name = this.comboRevistasMetadata.getSelectedItem().toString();

        for(RevistaID rev : this.magazineList){
            if(rev.getTitle().compareToIgnoreCase(name)==0){
                System.out.println("Encontre: "+rev.getTitle() + " Regresando: "+rev.getID());
                return rev.getID();
            }
        }
        return 0;
    }


    private void authorFoundReferencesOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorFoundReferencesOKActionPerformed
        this.authorFoundReferencesTextArea.setBackground(Color.GREEN);
        this.authorFoundReferencesTextArea.setEditable(false);
    }//GEN-LAST:event_authorFoundReferencesOKActionPerformed

    private void titleFoundReferencesOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFoundReferencesOKActionPerformed
        this.titleFoundReferencesTextField.setBackground(Color.GREEN);
        this.titleFoundReferencesTextField.setEditable(false);
    }//GEN-LAST:event_titleFoundReferencesOKActionPerformed

    private void publisherFoundReferencesOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherFoundReferencesOkActionPerformed
        this.publisherFoundReferencesTextField.setBackground(Color.GREEN);
        this.publisherFoundReferencesTextField.setEditable(false);
    }//GEN-LAST:event_publisherFoundReferencesOkActionPerformed

    private void dateFoundReferencesOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFoundReferencesOkActionPerformed
        this.dateFoundReferencesTextField.setBackground(Color.GREEN);
        this.dateFoundReferencesTextField.setEditable(false);
    }//GEN-LAST:event_dateFoundReferencesOkActionPerformed

    private void pagesFoundReferencesOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagesFoundReferencesOkActionPerformed
        this.pagesFoundReferencesTextField.setBackground(Color.GREEN);
        this.pagesFoundReferencesTextField.setEditable(false);
    }//GEN-LAST:event_pagesFoundReferencesOkActionPerformed

    private void volumeFoundReferencesOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volumeFoundReferencesOkActionPerformed
        this.volumeFoundReferencesteTextField.setBackground(Color.GREEN);
        this.volumeFoundReferencesteTextField.setEditable(false);
    }//GEN-LAST:event_volumeFoundReferencesOkActionPerformed

    private void locationFoundReferencesOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationFoundReferencesOkActionPerformed
        this.locationFoundReferencesTextField.setBackground(Color.GREEN);
        this.locationFoundReferencesTextField.setEditable(false);
    }//GEN-LAST:event_locationFoundReferencesOkActionPerformed

    private void separadorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_separadorTxtActionPerformed
       String sep=separadorTxt.getText();
        if(sep.length()==1){
            if(GUIRenderer.isSeparator(sep)){
                if (formatFlag){
                    formatFlag=false;
                    nodeExample+=sep;
                    separadorTxt.setText("");
                    nodeExampleTxt.setText(nodeExample);
                    nodeExampleTxt.setText(nodeExample);
                    buildNodeTable();
                    botonAddUpper.setEnabled(true);
                    botonAddLower.setEnabled(true);
                    botonAddNumber.setEnabled(true);
                    SeparadorWindow.setVisible(false);
                    if ( (botonPredef8.getText().equals("Day") ) && !(nodeFormat.contains("D")) ){
                        botonPredef8.setEnabled(true);
                    }
                    if ( (botonPredef9.getText().equals("Year") ) && !(nodeFormat.contains("Y")) ){
                        botonPredef9.setEnabled(true);
                    }
                    if( (botonPredef8.getText().equals("Day")) || (botonPredef9.getText().equals("Year")) ){
                        botonAddNumber.setEnabled(false);
                    }
                    labelErrorSep.setText("");
                }else{
                    nodoAux+=sep;
                    citNodes.add(nodoAux);
                    trap=false;
                    nodoAux="";
                    separadorTxt.setText("");
                    SeparadorWindow.setVisible(false);
                    botonNuevoTipoCita.setEnabled(true);
                    closeControls.setEnabled(true);
                    labelErrorSep.setText("");
                }
            }
            else{
                separadorTxt.setText("");
                labelErrorSep.setText("El separador no puede ser ni letra ni numero");
            }
        }
        else{
            separadorTxt.setText("");
            labelErrorSep.setText("Ingrese por favor un unico caracter de separacion");
        }
    }//GEN-LAST:event_separadorTxtActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        citNodes=new Vector();
        buildCitTable();
        nodeFormatExampleTxt.setText("");
    }//GEN-LAST:event_comboTipoActionPerformed

    private void authorFoundReferencesWRONGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorFoundReferencesWRONGActionPerformed
        this.authorFoundReferencesTextArea.setEditable(true);
        this.authorFoundReferencesTextArea.setBackground(Color.YELLOW);
    }//GEN-LAST:event_authorFoundReferencesWRONGActionPerformed

    private void titleFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFoundReferencesWrongActionPerformed
        this.titleFoundReferencesTextField.setEditable(true);
        this.titleFoundReferencesTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_titleFoundReferencesWrongActionPerformed

    private void publisherFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherFoundReferencesWrongActionPerformed
        this.publisherFoundReferencesTextField.setEditable(true);
        this.publisherFoundReferencesTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_publisherFoundReferencesWrongActionPerformed

    private void dateFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFoundReferencesWrongActionPerformed
        this.dateFoundReferencesTextField.setEditable(true);
        this.dateFoundReferencesTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_dateFoundReferencesWrongActionPerformed

    private void pagesFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagesFoundReferencesWrongActionPerformed
        this.pagesFoundReferencesTextField.setEditable(true);
        this.pagesFoundReferencesTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_pagesFoundReferencesWrongActionPerformed

    private void volumeFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volumeFoundReferencesWrongActionPerformed
        this.volumeFoundReferencesteTextField.setEditable(true);
        this.volumeFoundReferencesteTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_volumeFoundReferencesWrongActionPerformed

    private void locationFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationFoundReferencesWrongActionPerformed
        this.locationFoundReferencesTextField.setEditable(true);
        this.locationFoundReferencesTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_locationFoundReferencesWrongActionPerformed

    private void magazineFoundReferencesOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magazineFoundReferencesOKActionPerformed
        this.magazineFoundReferencesTextField.setBackground(Color.GREEN);
        this.magazineFoundReferencesTextField.setEditable(false);
    }//GEN-LAST:event_magazineFoundReferencesOKActionPerformed

    private void magazineFoundReferencesWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magazineFoundReferencesWrongActionPerformed
        this.magazineFoundReferencesTextField.setEditable(true);
        this.magazineFoundReferencesTextField.setBackground(Color.YELLOW);
    }//GEN-LAST:event_magazineFoundReferencesWrongActionPerformed

    private void MenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuFileActionPerformed

    private void aboutTheBoxMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutTheBoxMenuActionPerformed
        Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        AboutTheBoxWindow aboutWindow = new AboutTheBoxWindow();
        aboutWindow.setBounds( (screen.width/2)-265 , (screen.height/2)-265, 550, 530);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutTheBoxMenuActionPerformed

    /**
     * Limpia las interfaces donde se despliegan las cosas
     */
    public void cleanGUI() {
        this.authorFoundReferencesTextArea.setBackground(Color.WHITE);
        this.titleFoundReferencesTextField.setBackground(Color.WHITE);
        this.dateFoundReferencesTextField.setBackground(Color.WHITE);
        this.extraFoundReferencesTextArea.setBackground(Color.WHITE);
        this.locationFoundReferencesTextField.setBackground(Color.WHITE);
        this.publisherFoundReferencesTextField.setBackground(Color.WHITE);
        this.pagesFoundReferencesTextField.setBackground(Color.WHITE);
        this.volumeFoundReferencesteTextField.setBackground(Color.WHITE);
        this.magazineFoundReferencesTextField.setBackground(Color.WHITE);
        this.originalReferenceTextArea.setBackground(Color.WHITE);

        this.authorFoundReferencesTextArea.setEditable(false);
        this.titleFoundReferencesTextField.setEditable(false);
        this.dateFoundReferencesTextField.setEditable(false);
        this.locationFoundReferencesTextField.setEditable(false);
        this.publisherFoundReferencesTextField.setEditable(false);
        this.pagesFoundReferencesTextField.setEditable(false);
        this.volumeFoundReferencesteTextField.setEditable(false);
        this.magazineFoundReferencesTextField.setEditable(false);
        this.originalReferenceTextArea.setEditable(false);

        this.authorFoundReferencesTextArea.setText("");
        this.titleFoundReferencesTextField.setText("");
        this.dateFoundReferencesTextField.setText("");
        this.extraFoundReferencesTextArea.setText("");
        this.locationFoundReferencesTextField.setText("");
        this.publisherFoundReferencesTextField.setText("");
        this.pagesFoundReferencesTextField.setText("");
        this.volumeFoundReferencesteTextField.setText("");
        this.magazineFoundReferencesTextField.setText("");
        this.originalReferenceTextArea.setText("");
        this.issnFoundReferencesTextField.setText("");
        this.isbnFoundReferencesTextField.setText("");
        this.institutionTextField.setText("");
        this.urlTextField.setText("");
        this.numberTextField.setText("");

        this.counterLabelFoundReferences.setText("-/-");

    }


    /**
     * Disables the format buttons and predef buttons of the Window RulesByNode "ReglasPorNodoWindow"
     */
    public void disableAllFormatButtons(){
        botonAddSeparator.setEnabled(false);
        botonAddUpper.setEnabled(false);
        botonAddLower.setEnabled(false);
        botonAddNumber.setEnabled(false);
        botonPredef8.setEnabled(false);
        botonPredef9.setEnabled(false);
    }

/**
 * Obtains a String representing a citation template - must be control's layer
 * @return
 */
    public String getDefinedCitationString(){
        String citationPattern="Autor.Fecha.Titulo.Volumen/Paginas.Lugar/Editorial.";
        return citationPattern;
    }
    /**
     * Obtains the specific weights for each node in the current citation format
     * returns true if value is found
     * @return
     */
    public boolean getDefinedCitationMaps(){
        HashMap weights =new HashMap();//almacenara temporalmente los pesos de los nodos, si existen
        HashMap formats= new HashMap();//almacenara temporalmente los nodos, si existen
        //aqui se llenan los mapas con una llamada a control, con otro hashmap, respectivamente
        //tentativo weights= getWeightsMap(); weightsMap=HashMap(String, Vector(int));
        //tentativo formats= getFormatsMap(); formatsMap=HashMap(String,String);
        formats.put("Autor", "A , A ");
        Vector vc=new Vector();
        vc.add(25);vc.add(25);vc.add(25);vc.add(25);
        weights.put("Autor", null);
        formats.put("Fecha", "A , Y ");
        vc=new Vector();
        vc.add(34);vc.add(33);vc.add(33);
        weights.put("Fecha", vc);
        formats.put("Titulo", "A ");
        vc=new Vector();
        vc.add(100);
        weights.put("Titulo", null);
        formats.put("Volumen", "A , N ");
        vc=new Vector();
        vc.add(33);vc.add(34);vc.add(33);
        weights.put("Volumen", null);
        formats.put("Paginas", "A N ");
        vc=new Vector();
        vc.add(50);vc.add(50);
        weights.put("Paginas", null);
        formats.put("Lugar", "A , A ");
        vc=new Vector();
        vc.add(33);vc.add(33);vc.add(34);
        weights.put("Lugar", null);
        formats.put("Editorial", "A ");
        vc=new Vector();
        vc.add(100);
        weights.put("Editorial", vc);
        //Fin simulacion de llamada a control - se sustituye por asignacion

        //valida que formats y weights contengan algo, y ademas su tamaño sea el mismo
        if  (!(formats.isEmpty())&&!(weights.isEmpty()) &&(formats.size()==weights.size()) ){
            nodeFormatsMap=formats;
            nodeWeightMap=weights;
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame AgregarWindow;
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonSalirConfig;
    private javax.swing.JButton BotonSalirKB;
    private javax.swing.JFrame ConfigWindow;
    private javax.swing.JFrame FormatoCitaWindow;
    private javax.swing.JButton GuardarConfig;
    private javax.swing.JFrame KBWindow;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuItemPreferencias;
    private javax.swing.JMenuItem MenuOpenPDF;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JPasswordField PasswordFieldPass;
    private javax.swing.JFrame PesosParaNodoWindow;
    private javax.swing.JFrame ReglasPorNodoWindow;
    private javax.swing.JFrame ReglasWindow;
    private javax.swing.JFrame SeparadorWindow;
    private javax.swing.JTextField TextFieldAgregar;
    private javax.swing.JTextField TextFieldHost;
    private javax.swing.JTextField TextFieldPort;
    private javax.swing.JTextField TextFieldUser;
    private javax.swing.JMenuItem aboutTheBoxMenu;
    private javax.swing.JButton addAuthor;
    private javax.swing.JButton addDate;
    private javax.swing.JButton addPage;
    private javax.swing.JButton addPlace;
    private javax.swing.JButton addPublisher;
    private javax.swing.JButton addTitle;
    private javax.swing.JButton addVolume;
    private javax.swing.JTextArea areaRawData;
    private javax.swing.JButton authorFoundReferencesOK;
    private javax.swing.JTextArea authorFoundReferencesTextArea;
    private javax.swing.JButton authorFoundReferencesWRONG;
    private javax.swing.JButton botonAddLower;
    private javax.swing.JButton botonAddNumber;
    private javax.swing.JButton botonAddSeparator;
    private javax.swing.JButton botonAddUpper;
    private javax.swing.JButton botonNuevaCita;
    private javax.swing.JButton botonNuevoTipoCita;
    private javax.swing.JButton botonOKPesosParaNodo;
    private javax.swing.JButton botonPesosDefecto;
    private javax.swing.JButton botonPredef8;
    private javax.swing.JButton botonPredef9;
    private javax.swing.JButton botonReglasOK;
    private javax.swing.JButton clearButtonReferencias;
    private javax.swing.JButton closeControls;
    private javax.swing.JComboBox comboFormato;
    private javax.swing.JComboBox comboRevistasMetadata;
    private javax.swing.JComboBox comboSoporteReferences;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JComboBox comboTipoFoundReferences;
    private javax.swing.JComboBox comboTipoMedio;
    private javax.swing.JComboBox comboTiposCitas;
    private javax.swing.JLabel counterLabelFoundReferences;
    private javax.swing.JButton dateFoundReferencesOk;
    private javax.swing.JTextField dateFoundReferencesTextField;
    private javax.swing.JButton dateFoundReferencesWrong;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JTextArea extraFoundReferencesTextArea;
    private javax.swing.JTextField institutionTextField;
    private javax.swing.JTextField isbnFoundReferencesTextField;
    private javax.swing.JTextField issnFoundReferencesTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelControlesNodo;
    private javax.swing.JLabel jLabelInstitucion;
    private javax.swing.JLabel jLabelNombreCita;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelSoporte;
    private javax.swing.JLabel jLabelTipoCita;
    private javax.swing.JLabel jLabelUrl;
    private javax.swing.JPanel jPanelControlesNodo;
    private javax.swing.JPanel jPanelReglasNodo;
    private javax.swing.JPanel jPanelReglasNodo2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPaneCitaPrev;
    private javax.swing.JScrollPane jScrollPaneNodoCitaPrev;
    private javax.swing.JScrollPane jScrollPanelElementTable;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelComponentsExample;
    private javax.swing.JLabel labelControlsHint;
    private javax.swing.JLabel labelElegido;
    private javax.swing.JLabel labelErrorCita;
    private javax.swing.JLabel labelErrorSep;
    private javax.swing.JLabel labelISBNFoundReferences;
    private javax.swing.JLabel labelISSNFoundReferences;
    private javax.swing.JLabel labelInstructionsCitation;
    private javax.swing.JLabel labelMagazineFoundRefs;
    private javax.swing.JLabel labelModifiquePeso;
    private javax.swing.JLabel labelNodeFormatExample;
    private javax.swing.JLabel labelPesoDeElemento;
    private javax.swing.JLabel labelPesoTotal;
    private javax.swing.JLabel labelRevistaMetadata;
    private javax.swing.JLabel labelSeleccioneImportancia;
    private javax.swing.JLabel labelSelectDefaultWeights;
    private javax.swing.JLabel labelSelectKind;
    private javax.swing.JLabel labelSelectNodeElements;
    private javax.swing.JLabel labelSelectOneNode;
    private javax.swing.JLabel labelSelectType;
    private javax.swing.JLabel labelSeparatorSelection;
    private javax.swing.JLabel labelSumaAdvert;
    private javax.swing.JLabel labelSumaMsg;
    private javax.swing.JLabel labelTipoMedioFoundRefs;
    private javax.swing.JList listaDeEntidades;
    private javax.swing.JButton locationFoundReferencesOk;
    private javax.swing.JTextField locationFoundReferencesTextField;
    private javax.swing.JButton locationFoundReferencesWrong;
    private javax.swing.JButton magazineFoundReferencesOK;
    private javax.swing.JTextField magazineFoundReferencesTextField;
    private javax.swing.JButton magazineFoundReferencesWrong;
    private javax.swing.JMenuItem menuItemKBAutores;
    private javax.swing.JMenuItem menuItemKBEditoriales;
    private javax.swing.JMenuItem menuItemKBLugares;
    private javax.swing.JMenuItem menuItemKBTitulos;
    private javax.swing.JMenu menuKB;
    private javax.swing.JMenuItem menuKBAutores;
    private javax.swing.JMenuItem menuKBReferencias;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuReglas;
    private javax.swing.JMenuItem newCitation;
    private javax.swing.JButton nextButtonFoundReferences;
    private javax.swing.JTextField nodeExampleTxt;
    private javax.swing.JTextField nodeFormatExampleTxt;
    private javax.swing.JTextField nuevoTipoCitaTxt;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JTextArea originalReferenceTextArea;
    private javax.swing.JButton pagesFoundReferencesOk;
    private javax.swing.JTextField pagesFoundReferencesTextField;
    private javax.swing.JButton pagesFoundReferencesWrong;
    private javax.swing.JPanel panelElements;
    private javax.swing.JPanel panelFormatoCita;
    private javax.swing.JPanel panelFoundReferences;
    private javax.swing.JPanel panelMetadata;
    private javax.swing.JPanel panelOpciones1;
    private javax.swing.JPanel panelOpciones2;
    private javax.swing.JPanel panelPesos;
    private javax.swing.JPanel panelRawData;
    private javax.swing.JPanel panelReferenciasRAW;
    private javax.swing.JTextField pesoElemNodoTxt;
    private javax.swing.JTextField pesoTotalTxt;
    private javax.swing.JButton previewsButtonFoundReferences;
    private javax.swing.JButton publisherFoundReferencesOk;
    private javax.swing.JTextField publisherFoundReferencesTextField;
    private javax.swing.JButton publisherFoundReferencesWrong;
    private javax.swing.JLabel selectedElementLabel;
    private javax.swing.JTextField separadorTxt;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JTable tablaElementos;
    private javax.swing.JTable tablaNodos;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTextPane textPaneReferencias;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfCreador;
    private javax.swing.JTextField tfFechaDeCreacion;
    private javax.swing.JTextField tfFechaDeModificacion;
    private javax.swing.JTextField tfNumeroDePaginas;
    private javax.swing.JTextField tfPalabrasClave;
    private javax.swing.JTextField tfProductor;
    private javax.swing.JTextField tfTema;
    private javax.swing.JTextField tfTitulo;
    private javax.swing.JButton titleFoundReferencesOK;
    private javax.swing.JTextField titleFoundReferencesTextField;
    private javax.swing.JButton titleFoundReferencesWrong;
    private javax.swing.JComboBox typeOfCitationCombo;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JButton volumeFoundReferencesOk;
    private javax.swing.JButton volumeFoundReferencesWrong;
    private javax.swing.JTextField volumeFoundReferencesteTextField;
    // End of variables declaration//GEN-END:variables

}
