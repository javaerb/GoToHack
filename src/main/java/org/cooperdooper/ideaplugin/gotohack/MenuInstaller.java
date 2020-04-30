package org.cooperdooper.ideaplugin.gotohack;

import com.intellij.ide.AppLifecycleListener;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Pulls Go To menu back to top level.
 */
public class MenuInstaller implements AppLifecycleListener {

    private static final String GOTO_MENU_ID = "EditorPopupMenu.GoTo";

    private boolean loaded = false;

    @Override
    public void appFrameCreated(@NotNull List<String> commandLineArgs) {
        if (!loaded) {
            loaded = true; // regardless of outcome
            ActionManager manager = ActionManager.getInstance();
            DefaultActionGroup gotoPopup = (DefaultActionGroup) manager.getAction(GOTO_MENU_ID);
            if (gotoPopup != null && gotoPopup.isPopup()) {
                gotoPopup.setPopup(false);
                gotoPopup.addSeparator();
            }
        }
    }
}