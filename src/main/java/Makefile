JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Room.java \
	TestBed1.java
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
