# logic_engine
A proof-of-concept of a Groovy script processing engine for running scripts within a parent application.

# Build Commands
   
## To build normally:
use one of the following:

	mvn clean source:jar javadoc:jar install
	
	mvn clean source:jar javadoc:jar install -DskipTests
   
## To build licensing information:
	mvn site

## To build Javadoc
	mvn javadoc:javadoc
   
## To list new versions of third-party components:
	mvn versions:display-dependency-updates

# Backlog
The Kanban Board for this project is located <a href="notes/kanban.txt">here.</a>
