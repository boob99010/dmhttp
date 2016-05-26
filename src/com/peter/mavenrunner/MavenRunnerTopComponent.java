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

import com.thoughtworks.xstream.XStream;
import java.awt.Font;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.w3c.dom.Document;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.api.project.ui.OpenProjects;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.spi.project.LookupProvider;
import org.netbeans.spi.project.ui.ProjectOpenedHook;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;
import org.openide.util.lookup.Lookups;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.w3c.dom.NodeList;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
		dtd = "-//com.peter.mavenrunner//MavenRunner//EN",
		autostore = false
)
@TopComponent.Description(
		preferredID = "MavenRunnerTopComponent",
		iconBase = "com/peter/mavenrunner/mavenIcon.png",
		persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "output", openAtStartup = false)
@ActionID(category = "Window", id = "com.peter.mavenrunner.MavenRunnerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
		displayName = "#CTL_MavenRunnerAction",
		preferredID = "MavenRunnerTopComponent"
)
@Messages({
	"CTL_MavenRunnerAction=MavenRunner",
	"CTL_MavenRunnerTopComponent=Maven runner",
	"HINT_MavenRunnerTopComponent=This is Maven runner"
})
@LookupProvider.Registration(projectType = {
	"org-netbeans-modules-ant-freeform",
	"org-netbeans-modules-j2ee-archiveproject",
	"org-netbeans-modules-j2ee-clientproject",
	"org-netbeans-modules-j2ee-earproject",
	"org-netbeans-modules-j2ee-ejbjarproject",
	"org-netbeans-modules-java-j2seproject",
	"org-netbeans-modules-maven",
	"org-netbeans-modules-web-clientproject",
	"org-netbeans-modules-web-project"
})

public final class MavenRunnerTopComponent extends TopComponent implements LookupProvider {

	static boolean isDebug = false;
	static MyTreeNode root = new MyTreeNode(null, null, null, null, false, "Projects", null, null);
	static DefaultTreeModel treeModel = new DefaultTreeModel(root);
	static Hashtable<String, ArrayList<PersistData>> data = new Hashtable<String, ArrayList<PersistData>>();

	public MavenRunnerTopComponent() {
		initComponents();
		setName(Bundle.CTL_MavenRunnerTopComponent());
		setToolTipText(Bundle.HINT_MavenRunnerTopComponent());
		if (!isDebug) {
			debugButton.setVisible(false);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treePopupMenu = new javax.swing.JPopupMenu();
        runMenuItem = new javax.swing.JMenuItem();
        addGoalMenuItem = new javax.swing.JMenuItem();
        editGoalMenuItem = new javax.swing.JMenuItem();
        deleteGoalMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        refreshMenuItem = new javax.swing.JMenuItem();
        treePanel = new javax.swing.JPanel();
        treeScrollPane = new javax.swing.JScrollPane();
        projectTree = new javax.swing.JTree();
        controlPanel = new javax.swing.JPanel();
        treeExpandButton = new javax.swing.JButton();
        treeCollapseButton = new javax.swing.JButton();
        hideEmptyProjectToggleButton = new javax.swing.JToggleButton();
        fontSizeIncreaseButton = new javax.swing.JButton();
        fontSizeDecreaseButton = new javax.swing.JButton();
        hideDefaultGoalButton = new javax.swing.JToggleButton();
        searchTextField = new javax.swing.JTextField();
        debugButton = new javax.swing.JButton();

        runMenuItem.setActionCommand(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.runMenuItem.actionCommand")); // NOI18N
        runMenuItem.setLabel(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.runMenuItem.label")); // NOI18N
        runMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMenuItemActionPerformed(evt);
            }
        });
        treePopupMenu.add(runMenuItem);
        runMenuItem.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.runMenuItem.AccessibleContext.accessibleName")); // NOI18N

        addGoalMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/add.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(addGoalMenuItem, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.addGoalMenuItem.text")); // NOI18N
        addGoalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGoalMenuItemActionPerformed(evt);
            }
        });
        treePopupMenu.add(addGoalMenuItem);

        editGoalMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/pencil.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editGoalMenuItem, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.editGoalMenuItem.text")); // NOI18N
        editGoalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGoalMenuItemActionPerformed(evt);
            }
        });
        treePopupMenu.add(editGoalMenuItem);

        deleteGoalMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/cross.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteGoalMenuItem, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.deleteGoalMenuItem.text")); // NOI18N
        deleteGoalMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGoalMenuItemActionPerformed(evt);
            }
        });
        treePopupMenu.add(deleteGoalMenuItem);
        treePopupMenu.add(jSeparator1);

        refreshMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/arrow_refresh.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(refreshMenuItem, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.refreshMenuItem.text")); // NOI18N
        refreshMenuItem.setToolTipText(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.refreshMenuItem.toolTipText")); // NOI18N
        refreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMenuItemActionPerformed(evt);
            }
        });
        treePopupMenu.add(refreshMenuItem);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        treePanel.setLayout(new java.awt.BorderLayout());

        projectTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectTreeMouseClicked(evt);
            }
        });
        treeScrollPane.setViewportView(projectTree);

        treePanel.add(treeScrollPane, java.awt.BorderLayout.CENTER);

        add(treePanel, java.awt.BorderLayout.CENTER);

        controlPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 2));

        treeExpandButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/treeExpand.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(treeExpandButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.treeExpandButton.text")); // NOI18N
        treeExpandButton.setPreferredSize(new java.awt.Dimension(26, 26));
        treeExpandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeExpandButtonActionPerformed(evt);
            }
        });
        controlPanel.add(treeExpandButton);

        treeCollapseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/treeCollapse.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(treeCollapseButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.treeCollapseButton.text")); // NOI18N
        treeCollapseButton.setPreferredSize(new java.awt.Dimension(26, 26));
        treeCollapseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeCollapseButtonActionPerformed(evt);
            }
        });
        controlPanel.add(treeCollapseButton);

        hideEmptyProjectToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/folder_delete.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(hideEmptyProjectToggleButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.hideEmptyProjectToggleButton.text")); // NOI18N
        hideEmptyProjectToggleButton.setToolTipText(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.hideEmptyProjectToggleButton.toolTipText")); // NOI18N
        hideEmptyProjectToggleButton.setPreferredSize(new java.awt.Dimension(26, 26));
        hideEmptyProjectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideEmptyProjectToggleButtonActionPerformed(evt);
            }
        });
        controlPanel.add(hideEmptyProjectToggleButton);

        fontSizeIncreaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/font_add.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(fontSizeIncreaseButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.fontSizeIncreaseButton.text")); // NOI18N
        fontSizeIncreaseButton.setPreferredSize(new java.awt.Dimension(26, 26));
        fontSizeIncreaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeIncreaseButtonActionPerformed(evt);
            }
        });
        controlPanel.add(fontSizeIncreaseButton);

        fontSizeDecreaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/font_delete.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(fontSizeDecreaseButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.fontSizeDecreaseButton.text")); // NOI18N
        fontSizeDecreaseButton.setPreferredSize(new java.awt.Dimension(26, 26));
        fontSizeDecreaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontSizeDecreaseButtonActionPerformed(evt);
            }
        });
        controlPanel.add(fontSizeDecreaseButton);

        hideDefaultGoalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/star.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(hideDefaultGoalButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.hideDefaultGoalButton.text")); // NOI18N
        hideDefaultGoalButton.setToolTipText(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.hideDefaultGoalButton.toolTipText")); // NOI18N
        hideDefaultGoalButton.setMaximumSize(null);
        hideDefaultGoalButton.setPreferredSize(new java.awt.Dimension(26, 26));
        hideDefaultGoalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideDefaultGoalButtonActionPerformed(evt);
            }
        });
        controlPanel.add(hideDefaultGoalButton);

        searchTextField.setText(org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.searchTextField.text")); // NOI18N
        searchTextField.setPreferredSize(new java.awt.Dimension(150, 26));
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        controlPanel.add(searchTextField);

        org.openide.awt.Mnemonics.setLocalizedText(debugButton, org.openide.util.NbBundle.getMessage(MavenRunnerTopComponent.class, "MavenRunnerTopComponent.debugButton.text")); // NOI18N
        debugButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugButtonActionPerformed(evt);
            }
        });
        controlPanel.add(debugButton);

        add(controlPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void projectTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTreeMouseClicked
		if (SwingUtilities.isRightMouseButton(evt)) {
			int row = projectTree.getClosestRowForLocation(evt.getX(), evt.getY());
			projectTree.setSelectionRow(row);
			MyTreeNode node = (MyTreeNode) projectTree.getSelectionPath().getLastPathComponent();
			if (!isDebug) {
				if (node.type.equals("project")) {
					addGoalMenuItem.setEnabled(true);
					editGoalMenuItem.setEnabled(false);
					deleteGoalMenuItem.setEnabled(false);

					runMenuItem.setEnabled(false);
				} else if (node.type.equals("goal")) {
					addGoalMenuItem.setEnabled(false);
					editGoalMenuItem.setEnabled(true);
					deleteGoalMenuItem.setEnabled(true);

					runMenuItem.setEnabled(true);
				} else if (node.type.equals("default goal")) {
					addGoalMenuItem.setEnabled(false);
					editGoalMenuItem.setEnabled(false);
					deleteGoalMenuItem.setEnabled(false);

					runMenuItem.setEnabled(true);
				}
			}
			treePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
		} else if (evt.getClickCount() == 2) {
			runGoal();
		}
    }//GEN-LAST:event_projectTreeMouseClicked

	private void runGoal() {
		if (projectTree.getSelectionPath() != null) {
			MyTreeNode node = (MyTreeNode) projectTree.getSelectionPath().getLastPathComponent();

			log("node.type=" + node.type);
			if (node.type.equals("goal") || node.type.equals("default goal")) {
				try {
					ClassLoader syscl = Lookup.getDefault().lookup(ClassLoader.class
					);
					List<String> goals = new ArrayList<String>();
					//goals.add("-Dmaven.tomcat.port=8082");
					String goalsStr[] = node.goals.split(" ");
					for (String goal : goalsStr) {
						goals.add(goal);
					}

					Class runUtils = syscl.loadClass("org.netbeans.modules.maven.api.execute.RunUtils");
					Method createRunConfig = runUtils.getMethod("createRunConfig", new Class[]{File.class, Project.class, String.class, List.class
					});
					Object rc = createRunConfig.invoke(null, FileUtil.toFile(node.project.getProjectDirectory()), node.project, node.projectInformation.getDisplayName(), goals);

					Class runConfig = syscl.loadClass("org.netbeans.modules.maven.api.execute.RunConfig");

					// maven properties
					Method setProperty = runConfig.getMethod("addProperties", new Class[]{Map.class});
					Map<String, String> properties = new HashMap<String, String>();
					for (String property : node.properties) {
						String s[] = property.split("=");
						if (s.length >= 2) {
							properties.put(s[0], s[1]);
						}
					}
					if (node.skipTests) {
						properties.put("maven.test.skip", "true");
					}
					setProperty.invoke(rc, properties);

					// maven profile
					log("node.profile=" + node.profile);
					if (!node.profile.trim().equals("")) {
						Method setActivatedProfiles = runConfig.getMethod("setActivatedProfiles", new Class[]{java.util.List.class
						});
						List<String> profiles = new ArrayList<String>();
						profiles.add(node.profile);
						setActivatedProfiles.invoke(rc, profiles);
					}

					Method executeMaven = runUtils.getMethod("executeMaven", new Class[]{runConfig});
					executeMaven.invoke(null, rc);
				} catch (Exception ex) {
					log(ExceptionUtils.getStackTrace(ex));
					ex.printStackTrace();
				}
			} else {
				//JOptionPane.showMessageDialog(this, "Wrong tree node type, it is not a maven goal", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please select a goal in tree", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

    private void refreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMenuItemActionPerformed
		refreshTree(true);
    }//GEN-LAST:event_refreshMenuItemActionPerformed

    private void addGoalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGoalMenuItemActionPerformed
		TreePath path = projectTree.getSelectionPath();
		if (path == null) {
			return;
		}

		MavenGoalDialog dialog = new MavenGoalDialog(null, true);
		dialog.setTitle("Add goals");
		dialog.setLocationRelativeTo(addGoalMenuItem);
		dialog.setVisible(true);
		//String goals = JOptionPane.showInputDialog(null, "Please input maven goals", "Add", JOptionPane.QUESTION_MESSAGE);
		if (!dialog.isCancel) {
			try {
				String name = dialog.nameTextField.getText();
				if (name.trim().equals("")) {
					return;
				}
				String goals = dialog.goalsTextField.getText();
				String profile = dialog.profileTextField.getText();
				List<String> properties = Arrays.asList(dialog.propertiesTextArea.getText().split("\n"));
				boolean skipTests = dialog.skipTestsCheckBox.isSelected();

				MyTreeNode node = (MyTreeNode) ((MyTreeNode) path.getLastPathComponent());
				MyTreeNode goalNode = new MyTreeNode(name, goals, profile, properties, skipTests, "goal", node.project, node.projectInformation);
				node.add(goalNode);
				projectTree.updateUI();

				String key = node.projectInformation.getDisplayName();
				ArrayList<PersistData> list = data.get(key);
				if (list == null) {
					list = new ArrayList<PersistData>();
					data.put(key, list);
				}
				list.add(new PersistData(goalNode.type, goalNode.projectInformation.getDisplayName(), goalNode.name, goalNode.goals, goalNode.profile, goalNode.properties, goalNode.skipTests));
				NbPreferences.forModule(this.getClass()).put("data", toString(data));
			} catch (Exception ex) {
				log(ExceptionUtils.getStackTrace(ex));
			}
		}
    }//GEN-LAST:event_addGoalMenuItemActionPerformed

    private void editGoalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGoalMenuItemActionPerformed
		TreePath path = projectTree.getSelectionPath();
		if (path == null) {
			return;
		}
		MyTreeNode node = (MyTreeNode) ((MyTreeNode) path.getLastPathComponent());
		if (node.type.equals("goal")) {
			MavenGoalDialog dialog = new MavenGoalDialog(null, true);
			dialog.setTitle("Edit goals");
			dialog.setLocationRelativeTo(addGoalMenuItem);
			dialog.nameTextField.setText(node.name);
			dialog.goalsTextField.setText(node.goals);
			dialog.profileTextField.setText(node.profile);
			dialog.propertiesTextArea.setText(StringUtils.join(node.properties, "\n"));
			dialog.skipTestsCheckBox.setSelected(node.skipTests);
			dialog.setVisible(true);

			if (!dialog.isCancel) {
				String name = dialog.nameTextField.getText();
				if (name.trim().equals("")) {
					return;
				}
				String key = node.projectInformation.getDisplayName();
				ArrayList<PersistData> list = data.get(key);
				if (list == null) {
					list = new ArrayList<PersistData>();
					data.put(key, list);
				}

				int index = 0;
				Iterator<PersistData> i = list.iterator();
				while (i.hasNext()) {
					PersistData p = i.next();
					if (p.name.equals(node.name)) {
						break;
					}
					index++;
				}

				String goals = dialog.goalsTextField.getText();
				String profile = dialog.profileTextField.getText();
				List<String> properties = Arrays.asList(dialog.propertiesTextArea.getText().split("\n"));
				boolean skipTests = dialog.skipTestsCheckBox.isSelected();

				log("index=" + index);
				list.remove(index);
				list.add(index, new PersistData(node.type, node.projectInformation.getDisplayName(), name, goals, profile, properties, skipTests));

				node.name = name;
				node.goals = goals;
				node.profile = profile;
				node.properties = properties;
				node.skipTests = skipTests;

				projectTree.updateUI();
				NbPreferences.forModule(this.getClass()).put("data", toString(data));
			}
		}
    }//GEN-LAST:event_editGoalMenuItemActionPerformed

    private void deleteGoalMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGoalMenuItemActionPerformed
		TreePath path = projectTree.getSelectionPath();
		if (path == null) {
			return;
		}
		MyTreeNode node = (MyTreeNode) ((MyTreeNode) path.getLastPathComponent());
		if (node.type.equals("goal") || isDebug) {
			MyTreeNode parentNode = (MyTreeNode) node.getParent();
			parentNode.remove(node);
			projectTree.updateUI();

			String key = node.projectInformation.getDisplayName();
			ArrayList<PersistData> list = data.get(key);
			if (list == null) {
				list = new ArrayList<PersistData>();
				data.put(key, list);
			}
			log("before delete " + list.size() + ", key=" + key);
			try {
				Iterator i = list.iterator();
				while (i.hasNext()) {
					PersistData p = (PersistData) i.next();
					if (p.name.equals(node.name)) {
						list.remove(p);
					}
				}
			} catch (Exception ex) {
				log(ExceptionUtils.getStackTrace(ex));
			}
			log("after delete " + list.size());
			NbPreferences.forModule(this.getClass()).put("data", toString(data));
		}
    }//GEN-LAST:event_deleteGoalMenuItemActionPerformed

    private void treeExpandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeExpandButtonActionPerformed
		expandAll(projectTree, true);
    }//GEN-LAST:event_treeExpandButtonActionPerformed

    private void treeCollapseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeCollapseButtonActionPerformed
		expandAll(projectTree, false);
    }//GEN-LAST:event_treeCollapseButtonActionPerformed

    private void hideEmptyProjectToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideEmptyProjectToggleButtonActionPerformed
		refreshTree(!hideEmptyProjectToggleButton.isSelected());
    }//GEN-LAST:event_hideEmptyProjectToggleButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
		refreshTree(!hideEmptyProjectToggleButton.isSelected());
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void fontSizeIncreaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontSizeIncreaseButtonActionPerformed
		MyTreeNodeRenderer renderer = (MyTreeNodeRenderer) projectTree.getCellRenderer();
		Font oldFont = renderer.getFont();
		Font font = new Font(oldFont.getFontName(), oldFont.getStyle(), oldFont.getSize() + 1);
		renderer.setFont(font);
		projectTree.updateUI();
		NbPreferences.forModule(this.getClass()).putInt("font", font.getSize());
    }//GEN-LAST:event_fontSizeIncreaseButtonActionPerformed

    private void fontSizeDecreaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontSizeDecreaseButtonActionPerformed
		MyTreeNodeRenderer renderer = (MyTreeNodeRenderer) projectTree.getCellRenderer();
		Font oldFont = renderer.getFont();
		Font font = new Font(oldFont.getFontName(), oldFont.getStyle(), oldFont.getSize() - 1);
		renderer.setFont(font);
		projectTree.updateUI();
		NbPreferences.forModule(this.getClass()).putInt("font", font.getSize());
    }//GEN-LAST:event_fontSizeDecreaseButtonActionPerformed

    private void debugButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugButtonActionPerformed
		log(String.valueOf(root.getChildCount()));
		log(" ---------- tempRoot 3 = " + root.getChildCount() + " , " + root);
//		try {
//			ClassLoader syscl = Lookup.getDefault().lookup(ClassLoader.class
//			);
//			Class runUtils = syscl.loadClass("org.netbeans.modules.maven.api.execute.RunUtils");
//			Class runConfig = syscl.loadClass("org.netbeans.modules.maven.api.execute.RunConfig");
//			Method[] m = runConfig.getDeclaredMethods();
//			for (int i = 0; i < m.length; i++) {
//				log(m[i].toString());
//			}
//		} catch (ClassNotFoundException ex) {
//			Exceptions.printStackTrace(ex);
//		}
    }//GEN-LAST:event_debugButtonActionPerformed

    private void hideDefaultGoalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideDefaultGoalButtonActionPerformed
		refreshTree(!hideEmptyProjectToggleButton.isSelected());
    }//GEN-LAST:event_hideDefaultGoalButtonActionPerformed

    private void runMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMenuItemActionPerformed
		runGoal();
    }//GEN-LAST:event_runMenuItemActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
		projectTree.requestFocus();
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addGoalMenuItem;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton debugButton;
    private javax.swing.JMenuItem deleteGoalMenuItem;
    private javax.swing.JMenuItem editGoalMenuItem;
    private javax.swing.JButton fontSizeDecreaseButton;
    private javax.swing.JButton fontSizeIncreaseButton;
    private javax.swing.JToggleButton hideDefaultGoalButton;
    private javax.swing.JToggleButton hideEmptyProjectToggleButton;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTree projectTree;
    private javax.swing.JMenuItem refreshMenuItem;
    private javax.swing.JMenuItem runMenuItem;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton treeCollapseButton;
    private javax.swing.JButton treeExpandButton;
    private javax.swing.JPanel treePanel;
    private javax.swing.JPopupMenu treePopupMenu;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables

	@Override
	public void componentOpened() {
		log("----- componentOpened -----");
		projectTree.setModel(treeModel);
		projectTree.setShowsRootHandles(true);
		projectTree.setRootVisible(false);
		MyTreeNodeRenderer renderer = new MyTreeNodeRenderer();
		projectTree.setCellRenderer(renderer);

		Font oldFont = renderer.getFont();
		Font font = new Font(oldFont.getFontName(), oldFont.getStyle(), NbPreferences.forModule(this.getClass()).getInt("font", 12));
		renderer.setFont(font);
		refreshTree(true);
	}

	@Override
	public void componentClosed() {
	}

	void writeProperties(java.util.Properties p) {
	}

	void readProperties(java.util.Properties p) {
	}

	void refreshTree(boolean showEmptyNode) {
		log("refreshTree");
		root.removeAllChildren();

		try {
			String searchString = searchTextField.getText().trim();

			for (Project p : OpenProjects.getDefault().getOpenProjects()) {
				ProjectInformation projectInformation = p.getLookup().lookup(ProjectInformation.class);
				log(projectInformation.getDisplayName());
				if (!new File(p.getProjectDirectory().getPath() + File.separator + "pom.xml").exists()) {
					continue;
				}
				MyTreeNode node = new MyTreeNode(projectInformation.getDisplayName(), null, null, null, false, "project", p, projectInformation);
				node.icon = projectInformation.getIcon();

				// load goals from nbactions.xml
				if (!hideDefaultGoalButton.isSelected()) {
					if (new File(p.getProjectDirectory().getPath() + File.separator + "nbactions.xml").exists()) {
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document doc = builder.parse(p.getProjectDirectory().getPath() + File.separator + "nbactions.xml");
						XPathFactory xPathfactory = XPathFactory.newInstance();
						XPath xpath = xPathfactory.newXPath();
						XPathExpression expr = xpath.compile("//action");
						NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
						for (int x = 0; x < nl.getLength(); x++) {
							NodeList childs = nl.item(x).getChildNodes();
							String displayName = null;
							String actionName = null;
							String goals = "";
							String profiles = "";
							List<String> properties = new ArrayList<String>();
							boolean skipTest = false;

							for (int y = 0; y < childs.getLength(); y++) {
								//log(childs.item(y).getNodeName());
								if (childs.item(y).getNodeName().equals("displayName")) {
									displayName = childs.item(y).getTextContent();
								} else if (childs.item(y).getNodeName().equals("actionName")) {
									actionName = childs.item(y).getTextContent();
								} else if (childs.item(y).getNodeName().equals("goals")) {
									NodeList goalNodes = childs.item(y).getChildNodes();
									for (int z = 0; z < goalNodes.getLength(); z++) {
										if (goalNodes.item(z).getNodeName().equals("goal")) {
											goals += goalNodes.item(z).getTextContent() + " ";
										}
									}
								} else if (childs.item(y).getNodeName().equals("activatedProfiles")) {
									NodeList profileNodes = childs.item(y).getChildNodes();
									for (int z = 0; z < profileNodes.getLength(); z++) {
										if (profileNodes.item(z).getNodeName().equals("activatedProfile")) {
											profiles += profileNodes.item(z).getTextContent() + " ";
										}
									}
								} else if (childs.item(y).getNodeName().equals("properties")) {
									NodeList profileNodes = childs.item(y).getChildNodes();
									for (int z = 0; z < profileNodes.getLength(); z++) {
										if (!profileNodes.item(z).getNodeName().equals("#text")) {
											properties.add(">" + profileNodes.item(z).getNodeName() + "=" + profileNodes.item(z).getTextContent().trim());
											if (profileNodes.item(z).getNodeName().equals("skipTests")) {
												skipTest = Boolean.parseBoolean(profileNodes.item(z).getTextContent().trim());
											}
										}
									}
								}
							}
//							log(displayName == null ? actionName : displayName + "=" + goals + ", " + profiles + ", " + skipTest);
//							for (String pp : properties) {
//								log("   " + pp);
//							}
//							log("--------");
							MyTreeNode goalNode = new MyTreeNode(displayName == null ? actionName : displayName, goals, profiles, properties, skipTest, "default goal", node.project, node.projectInformation);
							if ((searchString.equals("") || goalNode.name.toLowerCase().contains(searchString.toLowerCase())) && !goalNode.name.trim().equals("") && goalNode.type.equals("default goal")) {
								node.add(goalNode);
								goalNode.icon = (new javax.swing.ImageIcon(getClass().getResource("/com/peter/mavenrunner/star.png")));
							}
						}
					}
				}
				// end load goals from nbactions.xml

				// load goals
				try {
					String key = node.projectInformation.getDisplayName();
					String value = NbPreferences.forModule(this.getClass()).get("data", null);
					//log("value=" + value);
					data = fromString(value);
					if (data == null) {
						data = new Hashtable< String, ArrayList<PersistData>>();
						//log("  create new data");
					}
					if (data.get(key) == null) {
						data.put(key, new ArrayList<PersistData>());
						//log("  add " + key + " to data");
					}
					ArrayList<PersistData> persistData = data.get(key);
					if (persistData != null) {
						for (PersistData n : persistData) {
							if ((searchString.equals("") || n.name.toLowerCase().contains(searchString.toLowerCase())) && !n.name.trim().equals("") && n.type.equals("goal")) {
								node.add(new MyTreeNode(n.name, n.goals, n.profile, n.properties, n.skipTests, n.type, node.project, node.projectInformation));
							}
						}
					}
				} catch (Exception ex) {
					log(ExceptionUtils.getStackTrace(ex));
					// old version of data throws here
					data = new Hashtable< String, ArrayList<PersistData>>();
					NbPreferences.forModule(this.getClass()).put("data", toString(data));
				}
				// load goals end

				if (showEmptyNode || node.getChildCount() > 0) {
					root.add(node);
				}
			}
		} catch (Exception ex) {
			log(ExceptionUtils.getStackTrace(ex));
		}

		treeModel.nodeStructureChanged(root);
		expandAll(projectTree, true);
	}

	public void expandAll(JTree tree, boolean expand) {
		expandAll(tree, expand, -1);
	}

	public void expandAll(JTree tree, boolean expand, int maxLevel) {
		MyTreeNode tempRoot = (MyTreeNode) treeModel.getRoot();
		if (tempRoot != null) {
//			log(" ---------- tempRoot 2 = " + tempRoot.getChildCount() + " , " + tempRoot);
//			for (int x = 0; x < tempRoot.getChildCount(); x++) {
//				log("                --------> " + x + " = " + tempRoot.getChildAt(x));
//			}
			expandAll(tree, new TreePath(tempRoot), expand, maxLevel, 0);
			tree.expandPath(new TreePath(tempRoot));
		}
	}

	private static void expandAll(JTree tree, TreePath treePath, boolean expand, int maxLevel, int currentLevel) {
		if (maxLevel != -1 && currentLevel >= maxLevel - 1) {
			return;
		}

		TreeNode node = (TreeNode) treePath.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration<TreeNode> e = node.children(); e.hasMoreElements();) {
				TreeNode n = e.nextElement();

				TreePath path = treePath.pathByAddingChild(n);
				expandAll(tree, path, expand, maxLevel, currentLevel + 1);
			}
		}

		// Expansion or collapse must be done bottom-up
		if (expand) {
			tree.expandPath(treePath);
		} else {
			tree.collapsePath(treePath);
		}
	}

	@Override
	public int getPersistenceType() {
		return TopComponent.PERSISTENCE_ALWAYS;
	}

	private Hashtable<String, ArrayList<PersistData>> fromString(String s) {
		try {
			XStream xstream = new XStream();
			return (Hashtable<String, ArrayList<PersistData>>) xstream.fromXML(s);
		} catch (Exception ex) {
			log(ExceptionUtils.getStackTrace(ex));
			return null;
		}
	}

	private String toString(Hashtable<String, ArrayList<PersistData>> o) {
		XStream xstream = new XStream();
		return xstream.toXML(o);
	}

	public static void log(String str) {
		if (isDebug) {
			InputOutput io = IOProvider.getDefault().getIO("MavenRunner", false);
			io.getOut().println(str);
		}
	}

	@Override
	public Lookup createAdditionalLookup(Lookup lookup) {
		Project p = lookup.lookup(Project.class);
		//final String name = p.getProjectDirectory().getName();

		return Lookups.fixed(new ProjectOpenedHook() {
			@Override
			protected void projectOpened() {
				refreshTree(!hideEmptyProjectToggleButton.isSelected());
			}

			@Override
			protected void projectClosed() {
				refreshTree(!hideEmptyProjectToggleButton.isSelected());
			}
		});
	}
}
