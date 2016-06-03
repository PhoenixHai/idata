package org.idata.velovity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

public class VelocityLayoutToolboxView extends VelocityLayoutView {
	@Override
	protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ViewToolContext ctx = new ViewToolContext(this.getVelocityEngine(), request, response,
				this.getServletContext());

		if (this.getToolboxConfigLocation() != null) {
			ToolManager tm = new ToolManager();
			tm.setVelocityEngine(this.getVelocityEngine());
			tm.configure(this.getToolboxConfigLocation());

			for (String scope : Scope.values()) {
				ctx.addToolbox(tm.getToolboxFactory().createToolbox(scope));
			}
		}

		if (model != null && !model.isEmpty()) {
			ctx.putAll(model);
		}

		return ctx;
	}
}