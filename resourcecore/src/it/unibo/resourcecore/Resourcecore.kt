/* Generated by AN DISI Unibo */ 
package it.unibo.resourcecore

import it.unibo.kactor.*
import alice.tuprolog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
	
class Resourcecore ( name: String, scope: CoroutineScope  ) : ActorBasicFsm( name, scope ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						println("resourcecore READY")
					}
					 transition(edgeName="t00",targetState="handleRequestCmd",cond=whenRequest("cmd"))
					transition(edgeName="t01",targetState="handleAlarm",cond=whenEvent("alarm"))
				}	 
				state("handleAlarm") { //this:State
					action { //it:State
						println("$name in ${currentState.stateName} | $currentMsg")
					}
					 transition(edgeName="t02",targetState="handleRequestCmd",cond=whenRequest("cmd"))
					transition(edgeName="t03",targetState="handleAlarm",cond=whenEvent("alarm"))
				}	 
				state("handleRequestCmd") { //this:State
					action { //it:State
						println("$name in ${currentState.stateName} | $currentMsg")
						if( checkMsgContent( Term.createTerm("cmd(X)"), Term.createTerm("cmd(X)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 val ANSW = "answerFor_${payloadArg(0)}"  
								answer("cmd", "replytocmd", "replytocmd($ANSW)"   )  
						}
					}
					 transition( edgeName="goto",targetState="s0", cond=doswitch() )
				}	 
			}
		}
}
