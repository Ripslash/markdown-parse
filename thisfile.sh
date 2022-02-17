
PEE=$3
declare -i PEE
PEE=PEE*10000

echo $PEE

java -jar ../public/bin/simulator.jar --data-structure $1 --size $PEE --operation $2 --iteration 1000 --round 5