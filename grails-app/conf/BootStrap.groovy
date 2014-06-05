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
        
        def pr1  = new entities.PartyRole(role:"Προσφέρων", roleInt:"Offerer").save()
        def pr2  = new entities.PartyRole(role:"Αποδέκτης", roleInt:"Acceptor").save()
        def pr3  = new entities.PartyRole(role:"Πρώτος Αποδέκτης", roleInt:"Primary Acceptor").save()
        def pr4  = new entities.PartyRole(role:"Δεύτερος Αποδέκτης", roleInt:"Secondary Acceptor").save()
        def pr5  = new entities.PartyRole(role:"Εγγυητής", roleInt:"Guarantor").save()
        def pr6  = new entities.PartyRole(role:"Αντίκλητος", roleInt:"Procedural Representative").save()
        def pr7  = new entities.PartyRole(role:"Νομικός Εκπρόσωπος", roleInt:"Legal Represetative").save()
        def pr8  = new entities.PartyRole(role:"Διαχειριστής", roleInt:"Administrator").save()
        def pr9  = new entities.PartyRole(role:"Κειδεμόνας", roleInt:"Custodian").save()
    }
    def destroy = {
    }
}
