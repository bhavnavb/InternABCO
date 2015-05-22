stat<- function(){
  wn <- read.csv("wine.csv",header=T,sep=",")  
  age<-wn$Age
  price<-wn$Price
  year<-wn$Year
  #plot(wn$WinterRain, wn$Price,xlab="Winter Rain",ylab="Price")
  #me=mean(wn[2,],na.rm=F)
  #print(class(wn1))
  tdata<-sample.split(wn,0.6)
  train=wn[tdata,1:6]
  test=wn[!tdata,1:6]
  m1=lm(formula=price~age+year,data=wn)
  
  #termplot(m1)
#  summary(m1)
  pdt<-predict(m1,test)
 print(pdt)
 print(rmse (pdt,test))
  #training<-(yr)
  #print(training)
  #train<-split(wn$yr)
  #print(class(yr))
 ## trdata = $wn1[training,]
  ##plot(wn$Age ~ wn$Price)
  ##plot(Age,Price,type="p",data=wn)
}