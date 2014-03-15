package entities

class AccOwner {   
    String              ownerType = "Persons"
    String              codeName
    Long                originOrgUnit=0     // like a specific branch, web, call center
    String              notes
    String              recStatus = "Active"
    Date                dateCreated
    Date                lastUpdated
    
    String toString() {"$codeName"}
    
    static mapping = {
        recStatus index:'AccOwnerRecordStatus_Idx'
    }    
    
    static hasMany = [ownerships:AccOwnership, ownerCategory:AccOwnerCategory]
//    static belongsTo = [accOwner:AccOwner]
    
    static constraints = {
        ownerType           (inList:["Persons", "Legal Entity"])
        codeName            (unique:true)
        ownerships          (nullable:true)
        ownerCategory       (nullable:true)
        originOrgUnit       (nullable:true, editable:false)
        notes               (nullable:true, size:0..2000, widget: 'textarea')
        recStatus           (editable:false, display:false, inList:["Active", "Deleted"])
        dateCreated() // implied => editable:false, bindable: false
        lastUpdated() // implied => editable:false, bindable: false  
    }
    def beforeUpdate() {
        codeName = codeName.toUpperCase()
    }    
}
