/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peter.mavenrunner;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.TreeCellRenderer;
import org.netbeans.api.project.ProjectInformation;

/**
 *
 * @author peter
 */
public class MyTreeNodeRenderer implements TreeCellRenderer {

	public JLabel label = new JLabel();

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		MyTreeNode treeNode = (MyTreeNode) value;
		label.setOpaque(true);
		if (treeNode.type != null && treeNode.type.equals("project")) {
			ProjectInformation pi = treeNode.projectInformation;
			label.setText(pi.getDisplayName());
		} else {
			label.setText(treeNode.name);
		}
		label.setIcon(treeNode.icon);
		if (selected) {
			label.setBackground(UIManager.getColor("Tree.selectionBackground"));
			label.setForeground(Color.white);
		} else {
			label.setBackground(UIManager.getColor("Tree.background"));
			label.setForeground(Color.black);
		}
		return label;
	}

}
