stat<- function(){
  wn <- read.csv("wine.csv",header=T,sep=",")  
  price<-wn$Price
  age<-wn$Age
  year<-wn$Year
  wr<-wn$WinterRain
  agst<-wn$AGST
  hr<-wn$HarvestRain
  fp<-wn$FrancePop  
  ## commented codes are for ur reference. 
  plot(wn$WinterRain, wn$Price,xlab="Winter Rain",ylab="Price")
 # me=mean(wn[2,],na.rm=F)
 # print(class(wn1))
  tdata<-sample.split(wn,0.6)
  train=wn[tdata,1:6]
  test=wn[!tdata,1:6]
 # plot(wn$Age, wn$FrancePop)
  m1=lm(formula=price~age+year,data=wn)
  m2=lm(formula=price~age+fp,data=wn)
  m3=lm(formula=price~hr+fp,data=wn)
 # abline(m1,col="green")
 # plot(m1,main="Age,year vs price") 
 # plot(m2,main="Winter Rain, AGST vs price") 
 # plot(m3,main="harvest Rain, FrancePop vs price")
 # termplot(m1)
 # summary(m1)
  p1<-predict(m1,test)
  r1<-rmse (p1,test)
  p2<-predict(m2,test)
  r2<-rmse (p2,test)
  p3<-predict(m3,test)
  r3<-rmse (p3,test)
  print(r1)
  print(r2)
  print(r3)
  v<-c(r1,r2,r3)
 print(v)
 i<-which.min(v)
 print(v[i])
 # training<-(yr)
 # print(training)
 # train<-split(wn$yr)
 # print(class(yr))
 # trdata = $wn1[training,]
 # plot(wn$Age ~ wn$Price)
 # plot(Age,Price,type="p",data=wn)
}