/*
 * SAP.java
 *
 * Created on 14-05-2008, 16:38:30
 */
 
package net2assignment1.sap;

import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.model.DefaultOptionsList;
import net2assignment1.*;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import dk.iha.onk.group1.server.dataTransferObjects.ReadingStationDTO;
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
    private Label labelUsername = new Label();

    public Label getLabelUsername() {
        return labelUsername;
    }

    public void setLabelUsername(Label l) {
        this.labelUsername = l;
    }
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

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SAPFrontpage() {
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
        labelUsername.setText(getSessionBean1().getUsername());
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
        ReadingStationDTO[] readingStations = getApplicationBean1().getAdminFacade().getReadingStations();
        Option[] options = new Option[readingStations.length];
        for(int i=0; i<readingStations.length; i++)
            options[i] = new Option(readingStations[i], readingStations[i].getName() + " [" + readingStations[i].getId() + "]");
        listboxReadingStations.setItems(options);
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

    public String buttonEdit_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        try {
            ReadingStationDTO rs = (ReadingStationDTO)listboxReadingStations.getValue();
            getRequestBean1().setReadingStation(rs);
            return "caseEdit";
        } catch(Exception ex) {
            return null;
        }
    }
    
}

