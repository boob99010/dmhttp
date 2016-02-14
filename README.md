# MavenRunner

 +Eclipse has a great plugin call "Eclipse runner" https://marketplace.eclipse.org/content/eclipse-runner , i found out netbeans doesn’t have any similar one. So i develop one for netbeans. You can add maven goals under the tree node of any project. Double click the goal name will run maven in netbeans. You can download it from http://plugins.netbeans.org/plugin/60381/mavenrunner , or search “Maven Runner” in netbeans’ plugin manager.
 
![alt tag](http://peter.kingofcoders.com/wp-content/uploads/2015/09/Maven-runner-big.png)

# Usage

After you installed MavenRunner, you can click window -> MavenRunner, the window will be added to your netbeans, then you can right click any project on that window and add mavel goal.

!!! when you enter something in the textbox, it will filter out goals for you, remember to hit enter

# Compile

Step 1) cd libInUse

Step 2) sh downloadJar.sh, it will download xstream library and all its dependency jars

Step 3) In netbeans, right click project -> properties -> libraries, add those jars (libInUse/lib) into your project

# License
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