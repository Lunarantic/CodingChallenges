read n

v=32
b=63
w=49
for i in $(seq $n)
do
    v=$(echo "$v/2" | bc)
    w=$(echo "$w-$v" | bc)
    b=$(echo "$b-$v-$v" | bc)
done

for r in $(seq $b)
do
    for c in $(seq 100); do echo -n "_"; done
    echo ""
done

vd=$(echo "($v*2)-1" | bc)
cvd=$(echo "($vd-1)/2" | bc)
w=$(echo "$w-$cvd" | bc)

for i in $(seq $n)
do
    for r in $(seq $v)
    do
        for c in $(seq $w); do echo -n "_"; done
        for cp in $(seq $(echo "2^($n-$i)" | bc))
        do
            for c in $(seq $cvd); do echo -n "_"; done
            echo -n "1"
            for c in $(seq $vd); do echo -n "_"; done
            echo -n "1"
            for c in $(seq $cvd); do echo -n "_"; done
            echo -n "_"
        done
        for c in $(seq $w); do echo -n "_"; done
        echo ""
        cvd=$(echo "$cvd+1" | bc)
        vd=$(echo "$vd-2" | bc)
    done
    for r in $(seq $v)
    do
        for c in $(seq $w); do echo -n "_"; done
        for cp in $(seq $(echo "2^($n-$i)" | bc))
        do
            for c in $(seq $cvd); do echo -n "_"; done
            echo -n "1"
            for c in $(seq $cvd); do echo -n "_"; done
            echo -n "_"
        done
        for c in $(seq $w); do echo -n "_"; done
        echo ""
    done
    v=$(echo "$v*2" | bc)
    vd=$(echo "($v*2)-1" | bc)
done

