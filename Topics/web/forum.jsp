<%@page import="forum.storage.Answer"%>
<%@page import="forum.storage.Topic"%>
<%@page import="logic.Answers"%>
<%@page import="logic.Topics"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ArrayList<Topics> listTopics = new ArrayList<Topics>();
        ArrayList<Answers> listAnswers = new ArrayList<Answers>();
        
        //take from Session object-topic
        Object topicObj = session.getAttribute("topic");
        Topic topic = new Topic();
        topic = (Topic)topicObj;
        
        listTopics = topic.getListTopics();
        
        Long idTopic;
        
        //take from Session object-answer
        Object answerObj = session.getAttribute("answer");
        Answer answer = new Answer();
        answer = (Answer)answerObj;
        
        listAnswers = answer.getListAnswers();
        
        %>
        <h1 align="center">On our website a lot of interesting!</h1>
        <form action="forum.htm" method="post" name="NameFormUsers">
            
			<a href="inputTopic.jsp">Add Topic</a>
			
			<table align="center" border="4" bordercolor="#000000" cellspacing="0" cellpadding="10">
			<caption>Topics</caption>
			</br>
                        <%
                    try{
                            
                        if(listTopics.size() != 0){
                            
                            for(int i=0;i<listTopics.size();i++){
                        %>
			<tr>
			  <th height="80" width="20%">
                              <%
                              Topics topics = listTopics.get(i);
                              out.println(topics.getTopicName());//PrintWriter out = response.getWriter();
                              
                              
                              idTopic = Long.valueOf(topics.getId());
                              
                              %>
                              
                              </br>
			    </br>
			  
                            <a href="inputAnswer.jsp?id=<%= idTopic %>">Add Answer</a>
                          
                          </th>
 		        </tr>
                              
                        <% 
                        if(listAnswers.size() != 0){
                            
                            for(int j=0; j<listAnswers.size(); j++){
                        
                              Answers answers = listAnswers.get(j);
                              Topics topicsId = answers.getIdTopic();
                              Long topicsIdL = Long.valueOf(topicsId.getId());
                              
                              if(idTopic == topicsIdL){ 
                                  %>
                                <tr>
			         <td>
                                 <%
                                  
                                  out.println(answers.getAnswerName());
                                 
                                 %>
   			         </td>
 			        </tr>
                    
                                 <%
                             
                                 }
                              
                               }//for
                              }//if
                            }//for    
                         }//if
                        else{
                            %>
                         <tr>
			   <td>
                            Empty;
                            </td>
 			 </tr>
                            <%
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                          %>
			  
                          
                        
                        
                        
			
                        </table>
        </br>
        <input align="center" type="submit" value="exit"/>

        </form>    
    </body>
</html>
