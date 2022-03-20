set val(chan)    Channel/WirelessChannel  ;#Channel type
set val(prop)    Propagation/TwoRayGround ;#radio-propagation model
set val(prop1)   Propagation/Shadowing    ;
set val(netif)   Phy/WirelessPhy          ;#network interface type
set val(mac)     Mac/802_11               ;#MAC_type
set val(ifq)     Queue/DropTail/PriQueue  ;#interface queue type
set val(ll)      LL                       ;#link layer type
set val(ant)     Antenna/OmniAntenna      ;#antenna model
set val(ifqlen)  50                       ;#max packet in ifq
set val(ifqlen1) 25                       ;
set val(nn)      6                        ;#number of nodes
set val(rp)      DSR                      ;#routin protcol adhoc on demand distance vector rouitn protocol
set val(rp1)     AODV                     ;
set val(x)       500
set val(y)       500


#Create simulator object 
set ns [new Simulator]


#create tracefile and namfile
set tracefile [open wireless.tr w]
$ns trace-all $tracefile

set namfile [open wireless.nam w]
$ns namtrace-all-wireless $namfile $val(x) $val(y)

#create topography 
set topo [new Topography]
$topo load_flatgrid $val(x) $val(y)

#god creation 
create-god $val(nn)

set channel1 [new $val(chan)]
set channel2 [new $val(chan)]


#configure the nodes
$ns node-config -adhocRouting $val(rp) \
                -llType $val(ll) \
                -macType $val(mac) \
                -ifqType $val(ifq) \
                -ifqLen $val(ifqlen) \
                -antType $val(ant) \
                -propType $val(prop) \
                -phyType $val(netif) \
                -topoInstance $topo \
                -agentTrace ON \
                -macTrace ON \
                -routerTrace ON \
                -movementTrace ON \
                -channel $channel1

set n0 [$ns node]
set n1 [$ns node]

$ns node-config -channel $channel2 \
                -adhocRouting $val(rp1) \
                -propType $val(prop1) \
                -ifqLen $val(ifqlen1)
                

set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]


$n0 random-motion 0
$n1 random-motion 0
$n2 random-motion 0
$n3 random-motion 0
$n4 random-motion 0
$n5 random-motion 0

#size of the node 
$ns initial_node_pos $n0 20
$ns initial_node_pos $n1 20
$ns initial_node_pos $n2 20
$ns initial_node_pos $n3 20
$ns initial_node_pos $n4 20
$ns initial_node_pos $n5 50

#initial coordinatess of the nodes

$n0 set X_ 10.0
$n0 set Y_ 20.0
$n0 set Z_ 0.0

$n1 set X_ 210.0
$n1 set Y_ 230.0
$n1 set Z_ 0.0

$n2 set X_ 100.0
$n2 set Y_ 200.0
$n2 set Z_ 0.0

$n3 set X_ 430.0
$n3 set Y_ 230.0
$n3 set Z_ 0.0

$n4 set X_ 270.0
$n4 set Y_ 150.0
$n4 set Z_ 0.0

$n5 set X_ 270.0
$n5 set Y_ 120.0
$n5 set Z_ 0.0


#mobility of the nodes
#at what time? whic node? wheree to ?at what speed?
#$ns at 1.0 "$n1 setdest 490.0 340.0 25.0"
#$ns at 1.0 "$n4 setdest 300.0 130.0 5.0"
#$ns at 1.0 "$n5 setdest 190.0 440.0 15.0"


#the nodes can move any number of time at any location during the simulation(runtime)
#$ns at 20.0 "$n5 setdest 100.0 200.0 30.0"

#creation of agents
set tcp [new Agent/TCP]
set sink [new Agent/TCPSink] 
$ns attach-agent $n0 $tcp
$ns attach-agent $n5 $sink
$ns connect $tcp $sink
set ftp [new Application/FTP]
$ftp attach-agent $tcp
$ns at 1.0 "$ftp start"

set udp [new Agent/UDP]
set null [new Agent/Null] 
$ns attach-agent $n2 $udp
$ns attach-agent $n3 $null
$ns connect $udp $null
set cbr [new Application/Traffic/CBR]
$cbr attach-agent $udp

$ns at 1.0 "$cbr start"

$ns at 30.0 "finish"

proc finish {} {

    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam wireless.nam &
    exit 0
}

$ns run








