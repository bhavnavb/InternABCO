fn1 <- function(){
  x <- 0:10
  as.logical(x)
}
fn2 <-function(){
  y<-list(1+3i,"b",9,F)
  as.logical(y)
}
fn3 <-function(){
  
  cars <- c(1,3,5,7,9)
  plot(cars,type="o",col="blue")
  truck <- c(3,5,4,6,2,8)
 lines(truck,type="o",col="red")
}

##pie(cars) #cntrl-alt + r

fn4 <- function(){
  tr <- read.csv(file="try.csv",header=T,sep=",")
  plot(tr)
  x<-lm(formula=Minutes~Units,data=tr)
  summary(x)
  abline(x,lty="dotted",col="red")
  predict(x)
  }