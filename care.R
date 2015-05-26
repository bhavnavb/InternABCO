lgrg<-function(){
   ql=read.csv("quality.csv",header=T,sep=",")
   pc<-ql$PoorCare
   qd<- sample.split(pc,0.75)
   qtrn<-ql[qd,1:14]
   qtst<-ql[!qd,1:14]
   lr=glm(pc~ql$OfficeVisits+ql$Narcotics,data=qtrn,family=binomial)
   predict(lr,newdata=qtst)
   rocprd <- prediction(qtrn,qtrn$PoorCare)
  }