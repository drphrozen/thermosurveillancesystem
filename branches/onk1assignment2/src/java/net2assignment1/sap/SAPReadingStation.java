/*
 * SAPReadingStation.java
 *
 * Created on 19-05-2008, 07:10:22
 */
 
package net2assignment1.sap;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import dk.iha.onk.group1.server.domainObjects.Probe;
import dk.iha.onk.group1.server.domainObjects.ReadingStation;
import javax.faces.FacesException;
import net2assignment1.ApplicationBean1;
import net2assignment1.SessionBean1;
import net2assignment1.RequestBean1;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author Esben
 */
public class SAPReadingStation extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Label labelID = new Label();

    public Label getLabelID() {
        return labelID;
    }

    public void setLabelID(Label l) {
        this.labelID = l;
    }

    // </editor-fold>
    
    private Probe[] probes = null;
    private ReadingStation readingStation = null;

    public ReadingStation getReadingStation() {
        return readingStation;
    }

    public void setReadingStation(ReadingStation readingStation) {
        this.readingStation = readingStation;
    }
    
    public Probe[] getProbes() {
        return probes;
    }

    public void setProbes(Probe[] probes) {
        this.probes = probes;
    }
    private Button buttonUpdate = new Button();

    public Button getButtonUpdate() {
        return buttonUpdate;
    }

    public void setButtonUpdate(Button b) {
        this.buttonUpdate = b;
    }
    private Checkbox checkboxEnabled = new Checkbox();

    public Checkbox getCheckboxEnabled() {
        return checkboxEnabled;
    }

    public void setCheckboxEnabled(Checkbox c) {
        this.checkboxEnabled = c;
    }
    private Table tableProbes = new Table();

    public Table getTableProbes() {
        return tableProbes;
    }

    public void setTableProbes(Table t) {
        this.tableProbes = t;
    }
    private TableRowGroup tableRowGroupProbes = new TableRowGroup();

    public TableRowGroup getTableRowGroupProbes() {
        return tableRowGroupProbes;
    }

    public void setTableRowGroupProbes(TableRowGroup trg) {
        this.tableRowGroupProbes = trg;
    }
    private Checkbox tableRowGroupProbesSelectionChild = new Checkbox();

    public Checkbox getTableRowGroupProbesSelectionChild() {
        return tableRowGroupProbesSelectionChild;
    }

    public void setTableRowGroupProbesSelectionChild(Checkbox c) {
        this.tableRowGroupProbesSelectionChild = c;
    }
    private TableColumn tableRowGroupProbesSelectionColumn = new TableColumn();

    public TableColumn getTableRowGroupProbesSelectionColumn() {
        return tableRowGroupProbesSelectionColumn;
    }

    public void setTableRowGroupProbesSelectionColumn(TableColumn tc) {
        this.tableRowGroupProbesSelectionColumn = tc;
    }
    private TextField textFieldName = new TextField();

    public TextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(TextField tf) {
        this.textFieldName = tf;
    }
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SAPReadingStation() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        SessionBean1 sessionBean1 = getSessionBean1();
        readingStation = (ReadingStation)sessionBean1.getObjectToEdit();
        probes = readingStation.getProbes().toArray(new Probe[0]);
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SAPReadingStation Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        if(getSessionBean1().getObjectToEdit() != null)
        {
            ReadingStation rs = (ReadingStation)getSessionBean1().getObjectToEdit();
            labelID.setText(rs.getId());
            textFieldName.setText(rs.getName());
            System.out.println("isEnabled: " + rs.isEnabled());
            checkboxEnabled.setSelected(rs.isEnabled());
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String buttonBack_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "caseDoneEdit";
    }

    public String buttonUpdate_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        int id = ((ReadingStation)getSessionBean1().getObjectToEdit()).getId();
        String name = textFieldName.getText().toString();
        getApplicationBean1().getDataSourceFacade().getReadingStationDSL().setReadingStationName(id, name);        System.out.println("isChecked: " + checkboxEnabled.isChecked());
        if(checkboxEnabled.isChecked())
            getApplicationBean1().getDataSourceFacade().getReadingStationDSL().enableReadingStation(name);
        else
            getApplicationBean1().getDataSourceFacade().getReadingStationDSL().disableReadingStation(name);
        ReadingStation rs = getApplicationBean1().getDataSourceFacade().getReadingStationDSL().getReadingStationById(id);
        if(rs != null)
            getSessionBean1().setObjectToEdit(rs);
        return null;
    }
    
}

