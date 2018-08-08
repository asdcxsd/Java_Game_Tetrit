import requests
def reque(link, methon):
    r = requests.request(methon, link);
    return r
if __name__ == "__main__":
    List = "CONNECT,DELETE,GET,HEAD,OPTIONS,PATCH,POST,PUT,TRACE"
    array = list()
    pp = list()
    print "*********************************************************"
    print "*                                                       *"
    print "*             HTTP verb request by asdcxsd              *"
    print "*                                                       *"
    print "*********************************************************"
    link = raw_input("Link: ");
    print(link)
    p = List.split(",")
    for i in p:
        check = reque(link, i);
        print i;
        print check;
        print("------");
        array.append(check.text);
        pp.append(i);
        
    
    for i in range(0, len(array), 1):
        OKe = True
        for j in range(i+1, len(array), 1):
            
            if (array[i] == array[j]):
                OKe = False;
        if OKe == True:
            print pp[i] + "\n" +array[i] + "---------------------------------------------------------------"
            
    print "The end."
