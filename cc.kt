import java.util.Date
interface Iparcours
{
    fun getDiplome()
}
//une classe data ne peut être open, abstract,
//sealed ou inner. son constructeur doit
//au moins avoir un paramètre
//les paramètres doivent être val ou var
//obligatoirement
//donc pour qu'on puisse hériter de cette 
//classe on va la rendre open et écrire notre
// méthode toString() manuellement
open class Personne (var cin:String, var nom:String, var age:Int)
{
    override fun toString()="Cin=$cin,nom=$cin et age=$age"
}
class Examen (var code:String)
{lateinit var intitule:String
var NumeroParcours:Int=0

    constructor(code:String, intitule:String ,NumeroParcours:Int):this(code)
    {
        this.intitule=intitule
        this.NumeroParcours=NumeroParcours
    }
}
class Score (var exam:Examen, var dateE:Date)
{
     var score:Int =0
    get()=field
    set(value){
        if (value<0 || value>1000)
        throw Exception("erreur score")
        field=value}
 constructor( dateE:Date,exam :Examen, score:Int):this(exam,dateE)
 {
    if (score<0 || score>1000)
    throw Exception("erreur score")
    this.score=score
 }
}
class Stagiaire (cin:String,nom:String,age:Int) :Personne(cin,nom,age),Iparcours
{ var NumInscription:Int=0
  var DateInscription:Date?=null
 var LstScores :MutableList <Score> =mutableListOf<Score>()

fun getCategorie()=when
{
    age>26->{"CA"}
    age <22->{"CC"}
    else ->{"CB"}
}
fun addScore(S:Score)
{
LstScores.add(S)

}
fun meilleurScore()=LstScores.maxBy { it.score }
override fun getDiplome()
=if(LstScores.count{it.score>= 700} >3) true else false 


}

fun main()
{
var P=Personne("AA12","Sabir",40)
println(P.toString())
}