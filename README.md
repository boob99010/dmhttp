# MavenRunner

Eclipse has a great plugin call “Eclipse runner” https://marketplace.eclipse.org/content/eclipse-runner , i found out netbeans doesn’t have any similar one. So i develop one for netbeans. You can add maven goals under the tree node of any project. Double click the goal name will run maven in netbeans. You can download it from http://plugins.netbeans.org/plugin/60365/?show=true , or search “Maven Runner” in netbeans’ plugin manager.

![alt tag](http://peter.kingofcoders.com/wp-content/uploads/2015/09/Maven-runner-big.png)

# Usage

After you installed MavenRunner, you can click window -> MavenRunner, the window will be added to your netbeans, then you can right click any project on that window and add mavel goal.

!!! when you enter something in the textbox, it will filter out goals for you, remember to hit enter

# Compile

Step 1) cd libInUse

Step 2) sh downloadJar.sh, it will download xstream library and all its dependency jars

Step 3) In netbeans, right click project -> properties -> libraries, add those jars (libInUse/lib) into your project
