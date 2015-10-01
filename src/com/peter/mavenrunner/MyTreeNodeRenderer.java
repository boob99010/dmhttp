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
public class MyTreeNodeRenderer extends JLabel implements TreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		MyTreeNode treeNode = (MyTreeNode) value;
		setOpaque(true);
		if (treeNode.type != null && treeNode.type.equals("project")) {
			ProjectInformation pi = treeNode.projectInformation;
			setText(pi.getDisplayName());
		} else {
			setText(treeNode.name);
		}
		setIcon(treeNode.icon);
		if (selected) {
			setBackground(UIManager.getColor("Tree.selectionBackground"));
			setForeground(UIManager.getColor("Tree.selectionForeground"));
		} else {
			setBackground(UIManager.getColor("Tree.background"));
			setForeground(UIManager.getColor("Tree.foreground"));
		}
		return this;
	}
}
