package entities

class AccOwnership {  
    String      owner   // Person ID or Legal Entity ID (UUID with prefix 'P' or 'L')
    String      rights ="All"
    String      ownerNotes
    String      notes       
    String      recStatus = "Active"
    Date        dateCreated
    Date        lastUpdated
    
    static belongsTo = [accOwner:AccOwner]
    
    static mapping = { 
        person      index:'AccOwnershipPerson_Idx'
        legalEntity index:'AccOwnershipLegal_Idx'
    }    
    
    static constraints = {
        accOwner    ()
        owner       ()
        rights      (inList:["All", "Primary", "Secondary"])
        ownerNotes  (nullable:true, size:0..255)
        notes       (nullable:true, size:0..255, widget: 'textarea')
        recStatus   (editable:false, display:false, inList:["Active", "Deleted"])
        dateCreated() // implied => editable:false, bindable: false
        lastUpdated() // implied => editable:false, bindable: false
    }
    
//    def beforeInsert() {
//        if ((!person && !legalEntity) || (person && legalEntity)){
//            return false
//        }
//    }
//    
//      def beforeUpdate() {
//        if ((!person && !legalEntity) || (person && legalEntity)){
//            return false
//        }
//    }
}
