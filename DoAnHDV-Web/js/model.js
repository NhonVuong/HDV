export function Student({id, lastName, firstName , gender, address, objectClassId, className}){
    let obj = {
        Id : (id) ? id : "", 
        LastName : (lastName) ? lastName : "", 
        FirstName: (firstName) ? firstName : "", 
        Gender : (gender) ? gender : "", 
        Address : (address) ? address : "", 
        ObjectClassId : (objectClassId) ? objectClassId : "",
        ClassName: (className) ? className : ""
    }
    return obj;
}

export function ClassSchool({id, name, facultyId}){
    let obj = {
        Id : (id) ? id : "",
        Name : (name) ? name : "",
        FacultyId : (facultyId) ? facultyId : ""
    }
    return obj;
}

export function Facutly({id, name}){
    let obj = {
        Id : (id) ? id : "",
        Name : (name) ? name : "",
    }
    return obj;
}
// function