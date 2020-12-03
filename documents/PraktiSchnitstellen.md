# Prakticom - Schnitstellenbeschreibung

## Student

| Pfad                                           | RückgabeDatentyp  | Schnittstellen                                          | HTTP-Request | Required Roles |
| ---------------------------------------------- | ----------------- | ------------------------------------------------------- | ------------ | -------------- |
| localhost:8080/api/student                     | List<Student>     | Erhalte alle Schüler                                    | GET          |                |
| localhost:8080/api/student/{id}                | Studenet          | Erhalte Schüler durch die Id {id}                       | GET          |                |
| localhost:8080/api/student/username/{username} | Student           | Erhalte Schüler durch den Username {username}           | GET          |                |
| localhost:8080/api/student/email/{email}       | Student           | Erhalte Schüler durch die Email {email}                 | GET          |                |
| localhost:8080/api/student                     | Response: 201     | Erzeuge neuen Schüler                                   | POST         |                |
| localhost:8080/api/student/{id}                | Response(Student) | Updated beliebige Felder eines Schülers mit der Id {id} | PUT          |                |
| localhost:8080/api/student/delete/{id}         | Response: 202     | Löscht Schüler mit der Id {id}                          | DELETE       |                |

## Company

| Pfad                                 | RückgabeDatentyp  | Schnittstellen                                         | HTTP-Request |Required Roles|
| ------------------------------------ | ----------------- | ------------------------------------------------------ | ------------ |---|
| localhost:8080/api/company           | List<Company>     | Erhalte alle Companies                                 | GET          ||
| localhost:8080/api/company/{id}      | Company           | Erhalte Company durch die Id {id}                      | GET          ||
| localhost:8080/api/company/url/{url} | Company           | Erhalte Company durch die URL {url}                    | GET          ||
| localhost:8080/api/company           | Response: 201     | Erzeuge neue Company                                   | POST         ||
| localhost:8080/api/company/{id}      | Response(Student) | Updated beliebige Felder einer Company mit der Id {id} | PUT          ||
| localhost:8080/api/company/{id}      | Response: 202     | Löscht Company mit der Id {id}                         | DELETE       ||
