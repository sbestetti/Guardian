package com.guardian.business.security;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import com.guardian.business.mb.LoggedUserBean;

public class SecurityFilter implements PhaseListener {

	private static final long serialVersionUID = -630576871684031310L;
	
	@Inject
	private LoggedUserBean loggedUserbean;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		if ("/index.xhtml".equals(context.getViewRoot().getViewId())/* || "/addteacher.xhtml".equals(context.getViewRoot().getViewId())*/) {
			return;
		}
		
		if (loggedUserbean.getLoggedUser() == null) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "index.xhtml?faces-redirect=true");
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		return;
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}