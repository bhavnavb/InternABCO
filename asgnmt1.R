## ASSIGNMENT 1
readdf <- function(){
##1 read csv into dataframe dfr
  dfr <- read.csv(file="who.csv",header=TRUE,sep=",") 
##2a show class of dfr (dataframe)
  cls<-  class(dfr)
  print(cls)
##2b show the structure of dfr  
  str(dfr)
##3
  summary(dfr)
## summary() gives the summary of the given data.
## calculates minimum,maximum value, mean,median,mode
##1st,3rd quartile and no of rows with no value(NA) in that column
#Q3 <- quantile(dfr, 0.75,na.rm=TRUE, type = 2) 
#Q1 <- quantile(dfr, 0.25,na.rm=FALSE, type = 2)  
#print (Q3 - Q1)
#IQR(dfr,na.rm=FALSE, type = 2)

##5 display required rows and write into another csv file
df<-data.frame(subset(dfr, Region=="Africa"))
write.csv(df,"C:/Users/intern/Documents/rprog/Africa.csv")
##dev<- sd(dfr.population,na.rm=TRUE)
tmp <-1:9
print(tmp)
##rm(tmp)
print(tmp)
}
