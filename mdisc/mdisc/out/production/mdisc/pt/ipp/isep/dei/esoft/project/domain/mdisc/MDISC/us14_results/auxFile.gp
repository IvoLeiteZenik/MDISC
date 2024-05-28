set terminal png

set output 'C:\Users\gonca\Downloads\mdisc\mdisc\mdisc\MDISC\us14_results\us14_.png'
set title 'Execution time tests'
set xlabel 'Size of Graph (number of edges)'
set ylabel 'Runtime (milliseconds)'
set grid
set xrange [0:*]
set yrange [0:*]
set style fill transparent solid 0.9
plot 'C:\Users\gonca\Downloads\mdisc\mdisc\mdisc\MDISC\us14_results\us14_.csv'  u 1:2 w p t 'Algorithm Performance'
