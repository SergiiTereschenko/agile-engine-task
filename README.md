# Find corrupted html element service #
Application accepts 2 files paths on start. 
1st - html page with original element, 2nd - html page where same element is corrupted. 
3d parameter can be target element Id.
The purpose of the app is to find element on the corrupted html which is the most similar to the element on the original htmp
Id of the original correct html element is "make-everything-ok-button"

##To run application:##

* Clone repository with command:

        git clone https://github.com/SergiiTereschenko/agile-engine-task.git

* Go to project directory and run build:

        ./gradlew clean build

* Example of how to run application:
                                                        
        java -jar build/libs/agile-engine-task-0.0.1.jar  sample-0-origin.html sample-2-container-and-clone.html
        or
        java -jar build/libs/agile-engine-task-0.0.1.jar  sample-0-origin.html sample-2-container-and-clone.html make-everything-ok-button
