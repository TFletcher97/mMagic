package net.tpf.magic.guis;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;

public class MagicGUI extends LightweightGuiDescription {



    private class DoRun implements Runnable {

        @Override
        public void run(){

        }

    }

    public MagicGUI(){

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(150, 100);

        WLabel label = new WLabel("Leveling Menu");
        root.add(label, 0, 0);

    }
}


