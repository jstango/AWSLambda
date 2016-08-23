package com.jstango.plugin;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stangoj on 8/23/16.
 */
public class PluginWindow implements ProjectComponent {

    private final Project project;
    public static final String TOOL_WINDOW_ID = "AWS Services Window";
    private static final Icon icon = IconLoader.getIcon("resources/icons/web_logo.png");


    public PluginWindow(Project project) {
        this.project = project;
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "AWS Plugin Window";
    }

    @Override
    public void projectOpened() {

        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(project);
        ToolWindow toolWindow = toolWindowManager.registerToolWindow(TOOL_WINDOW_ID, false, ToolWindowAnchor.BOTTOM);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(new AWSPluginWindowPanel(),"",false);
        toolWindow.getContentManager().addContent(content);
        toolWindow.setIcon(icon);

    }

    @Override
    public void projectClosed() {
        // called when project is being closed
    }
}
