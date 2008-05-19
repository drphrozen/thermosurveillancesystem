/*
 * SAP.java
 *
 * Created on 14-05-2008, 16:38:30
 */
 
package net2assignment1.sap;

import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import net2assignment1.*;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import dk.iha.onk.group1.server.domainObjects.ReadingStation;
import dk.iha.onk.group1.server.domainObjects.User;
import javax.faces.FacesException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author ESRA
 */
public class SAPFrontpage extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private ReadingStation[] readingStations = new ReadingStation[0];
    private User[] users = new User[0];
    
    private DefaultOptionsList listboxReadingStationsDefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getListboxReadingStationsDefaultOptions() {
        return listboxReadingStationsDefaultOptions;
    }

    public void setListboxReadingStationsDefaultOptions(DefaultOptionsList dol) {
        this.listboxReadingStationsDefaultOptions = dol;
    }
    private Listbox listboxReadingStations = new Listbox();

    public Listbox getListboxReadingStations() {
        return listboxReadingStations;
    }

    public void setListboxReadingStations(Listbox l) {
        this.listboxReadingStations = l;
    }
    private DefaultOptionsList listboxUsersDefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getListboxUsersDefaultOptions() {
        return listboxUsersDefaultOptions;
    }

    public void setListboxUsersDefaultOptions(DefaultOptionsList dol) {
        this.listboxUsersDefaultOptions = dol;
    }
    private Listbox listboxUsers = new Listbox();

    public Listbox getListboxUsers() {
        return listboxUsers;
    }

    public void setListboxUsers(Listbox l) {
        this.listboxUsers = l;
    }
    private SingleSelectOptionsList dropDownAccountTypeDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDownAccountTypeDefaultOptions() {
        return dropDownAccountTypeDefaultOptions;
    }

    public void setDropDownAccountTypeDefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDownAccountTypeDefaultOptions = ssol;
    }
    private DropDown dropDownAccountType = new DropDown();

    public DropDown getDropDownAccountType() {
        return dropDownAccountType;
    }

    public void setDropDownAccountType(DropDown dd) {
        this.dropDownAccountType = dd;
    }
    private TextField textFieldUsername = new TextField();

    public TextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public void setTextFieldUsername(TextField tf) {
        this.textFieldUsername = tf;
    }
    private PasswordField passwordFieldPassword = new PasswordField();

    public PasswordField getPasswordFieldPassword() {
        return passwordFieldPassword;
    }

    public void setPasswordFieldPassword(PasswordField pf) {
        this.passwordFieldPassword = pf;
    }
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SAPFrontpage() {
        Option[] accountTypes = new Option[] {
            new Option("admin", "Administrator"),
            new Option("user", "User")
        };
        dropDownAccountTypeDefaultOptions.setOptions(accountTypes);
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
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SAP Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
//        labelUsername.setText(getSessionBean1().getUsername());
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
        users = getApplicationBean1().getDataSourceFacade().getUserDSL().getUsers().toArray(new User[0]);
        Option[] userOptions = new Option[users.length];
        for (int i = 0; i < userOptions.length; i++)
            userOptions[i] = new Option(users[i].getId(), users[i].getUsername());
        listboxUsers.setItems(userOptions);
        
        readingStations = getApplicationBean1().getDataSourceFacade().getReadingStationDSL().getReadingStations().toArray(new ReadingStation[0]);
        Option[] readingStationOptions = new Option[readingStations.length];
        for(int i=0; i<readingStations.length; i++)
            readingStationOptions[i] = new Option(readingStations[i].getId(), readingStations[i].getName() + " [" + readingStations[i].getId() + "]");
        listboxReadingStations.setItems(readingStationOptions);
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public String buttonEditReadingStation_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        int id = Integer.parseInt(listboxReadingStations.getValue().toString());
        ReadingStation rs = getApplicationBean1().getDataSourceFacade().getReadingStationDSL().getReadingStationById(id);
        if(rs == null)
            return null;
        getSessionBean1().setObjectToEdit(rs);
        return "caseEditReadingStation";
    }

    public String buttonEditUsers_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        int id = Integer.parseInt(listboxUsers.getValue().toString());
        User user = getApplicationBean1().getDataSourceFacade().getUserDSL().getUser(id);
        if(user == null)
            return null;
        getSessionBean1().setObjectToEdit(user);
        return "caseEditUser";
    }

    public String tabUsers_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String buttonRemove_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        int id = Integer.parseInt(listboxUsers.getValue().toString());
        getApplicationBean1().getDataSourceFacade().getUserDSL().removeUser(id);
        return null;
    }

    public String buttonAdd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        getApplicationBean1().getDataSourceFacade().getUserDSL().addUser(getTextFieldUsername().getText().toString(), getPasswordFieldPassword().getText().toString(), getDropDownAccountType().getSelected().toString());
        return null;
    }
    
}

