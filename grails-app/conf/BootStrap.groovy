class BootStrap {

    def init = { servletContext ->
        
        def as1 = new entities.AccountStatus(title:"Ενεργός", titleInt:"Active").save() 
        def as2 = new entities.AccountStatus(title:"Κλειστός", titleInt:"Closed").save() 
        def as3 = new entities.AccountStatus(title:"Υπό Επεξεργασία", titleInt:"In Process").save() 
        def as4 = new entities.AccountStatus(title:"Αδρανής", titleInt:"Dormant").save() 
        def as5 = new entities.AccountStatus(title:"Δεσμευμένος", titleInt:"Blocked").save() 
        
        def at1 = new entities.AccountType(title:"Ενεργός", titleInt:"Active").save() 
        def at2 = new entities.AccountType(title:"Κλειστός", titleInt:"Closed").save() 
        def at3 = new entities.AccountType(title:"Υπό Επεξεργασία", titleInt:"In Process").save() 
        def at4 = new entities.AccountType(title:"Αδρανής", titleInt:"Dormant").save() 
        def at5 = new entities.AccountType(title:"Δεσμευμένος", titleInt:"Blocked").save()      
        
        def rl1 = new entities.RiskLevel(title:"Χαμηλό", titleInt:"Low").save()  
        def rl2 = new entities.RiskLevel(title:"Λογικό", titleInt:"Moderate").save()  
        def rl3 = new entities.RiskLevel(title:"Υψηλό", titleInt:"High").save()         
 
    }
    def destroy = {
    }
}
