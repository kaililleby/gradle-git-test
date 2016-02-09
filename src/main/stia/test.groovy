import org.ajoberstar.grgit.Commit
import org.ajoberstar.grgit.Grgit

public static void main(String[] args) {
    def repo = Grgit.open("/Users/kai/Dev/githome/gradle-git-test")

    /* def tag = repo.tag.add(name: "new-tag-${System.currentTimeMillis()}", message: 'Some message')
     println tag

     def push = repo.push(tags: true)
     println "push"
     println push
  */

    def tags = repo.tag.list()
    println "tags"
    println tags


    println ""
    println "hist"

    List<Commit> history = repo.log {
        range 'lagt_til_sti_b_tag', 'HEAD'
        //paths = ["src/main"]
    }

    def issuesToCommits = [:]

    //println history
    history.collect {
        def issues = it.fullMessage.findAll("#[0-9]+")
        println "issues" + issues
       return [issue: null, commit:it]
    }

}