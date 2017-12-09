

default: mmt/app/App.java
	javac `find . -name "*.java"` -d class/

clean:
	rm `find . -name "*.class"` -v

run:
	cd class ; java mmt.app.App ; cd ..

runtest2l:
	cd class ; ./runtests2LINUX.sh ; cd ..

zip:
	echo "zip not yet done"
