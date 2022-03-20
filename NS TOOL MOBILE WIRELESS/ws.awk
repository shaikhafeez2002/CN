BEGIN{
drop=0
stime=0
ftime=0
flag=0
fsize=0
throughput=0
latency=0
drop=0
}
{
if($1 == "r" )
{
fsize+=$6
if(flag==0)
{
stime=$2
flag=1
}
ftime=$2
}
if($1== "D")
{
drop++
}
}
END{
latency=ftime-stime
throughput=(fsize*8)/latency
printf("\n latency:%f",latency)
printf("\n throughput:%f",throughput)
printf("\n packet loss:%d",drop)
}

