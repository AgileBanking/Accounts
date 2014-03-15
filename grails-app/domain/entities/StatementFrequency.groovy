package entities

class StatementFrequency {
    String  code
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated
    Date    lastUpdated
    
    String toString() {"$code: $title/$titleInt"}
    
    static constraints = {
        code        unique:true, nullable:false, size:3..3
        title       unique:true, nullable:false
        titleInt    unique:true, nullable:false
        notes       nullable:true, maxsize:250, widget: 'textarea'
        recStatus   editable:false, display:false, inList:["Active", "Deleted"]
        dateCreated ()// implied => editable:false, bindable: false
        lastUpdated ()// implied => editable:false, bindable: false
    }
}
