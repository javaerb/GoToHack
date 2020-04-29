package org.cooperdooper.ideaplugin.gotohack;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.wm.IdeFrame;
import org.jetbrains.annotations.NotNull;

/**
 * Pulls Go To menu back to top level.
 */
public class MenuInstaller implements ApplicationActivationListener {

    private static final String GOTO_MENU_ID = "EditorPopupMenu.GoTo";

    private boolean loaded = false;

    @Override
    public void applicationActivated(@NotNull IdeFrame ideFrame) {
        if (!loaded) {
            loaded = true; // regardless of outcome
            ActionManager manager = ActionManager.getInstance();
            DefaultActionGroup gotoPopup = (DefaultActionGroup) manager.getAction(GOTO_MENU_ID);
            if (gotoPopup != null) {
                gotoPopup.setPopup(false);
                gotoPopup.addSeparator();
            }
        }
    }
}