/*
License
	Copyright (C) 2016 Peter Cheung (mcheung63@hotmail.com)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.peter.mavenrunner;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import org.netbeans.api.project.ProjectInformation;

/**
 *
 * @author peter
 */
public class MyTreeNodeRenderer extends JLabel implements TreeCellRenderer {

	public MyTreeNodeRenderer() {
		setBorder(new EmptyBorder(4, 4, 4, 4));
		setOpaque(true);
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		MyTreeNode treeNode = (MyTreeNode) value;
		if (treeNode.type != null && treeNode.type.equals("project")) {
			ProjectInformation pi = treeNode.projectInformation;
			setText(pi.getDisplayName());
		} else {
			setText(treeNode.name);
		}
		setIcon(treeNode.icon);
		if (selected) {
			if (UIManager.getColor("nimbusSelectionBackground") != null) {
				setBackground(UIManager.getColor("nimbusSelectionBackground"));
			} else {
				setBackground(UIManager.getColor("Tree.selectionBackground"));
			}
			setForeground(UIManager.getColor("Tree.selectionForeground"));
		} else {
			if (UIManager.getColor("nimbusBackground") != null) {
				setBackground(UIManager.getColor("nimbusBackground"));
			} else {
				setBackground(UIManager.getColor("Tree.background"));
			}
			setForeground(UIManager.getColor("Tree.foreground"));
		}
		//MavenRunnerTopComponent.log(UIManager.getColor("Tree.background").toString());

//		if (selected) {
//			setBackground(new Color(9, 80, 208));
//			setForeground(Color.white);
//		} else {
//			setBackground(Color.white);
//			setForeground(Color.black);
//		}
		return this;
	}
}
