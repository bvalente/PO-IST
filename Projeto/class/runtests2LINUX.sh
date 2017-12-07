#!/bin/bash

for x in tests2/*.in; do
    if [ -e ${x%.in}.import ]; then
        java -Dimport=${x%.in}.import -Din=$x -Dout=${x%.in}.outhyp mmt.app.App;
    else
        java -Din=$x -Dout=${x%.in}.outhyp mmt.app.App;
    fi

    diff -cB -w ${x%.in}.out ${x%.in}.outhyp > ${x%.in}.diff ;
    if [ -s ${x%.in}.diff ]; then
        echo "FAIL: $x. See file ${x%.in}.diff " ;
    else
        echo -n "."
        rm -f ${x%.in}.diff ${x%.in}.outhyp ;
    fi
done

rm -f saved*

echo "Done."

