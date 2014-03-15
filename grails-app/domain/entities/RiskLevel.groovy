package entities

class RiskLevel {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated 
    Date    lastUpdated 
    
    String toString() {"$title / $titleInt"}
    
    static constraints = {
        title       unique:true, size:2..40
        titleInt    unique:true, size:2..40
        notes       nullable:true, size:0..250, widget: 'textarea'
        recStatus   editable:false, display:false, inList:["Active", "Deleted"]
        dateCreated editable:false
        lastUpdated editable:false
    }
}
