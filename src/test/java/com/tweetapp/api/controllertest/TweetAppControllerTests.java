//package com.tweetapp.controller;
//
//import com.tweetapp.model.Tweet;
//import com.tweetapp.model.User;
//import com.tweetapp.repository.TweetRepository;
//import com.tweetapp.service.TweetService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
//class TweetControllerTest {
//
//    @Mock
//    TweetService tweetService;
//
//    @Mock
//    TweetRepository tweetRepository;	
//    
//    @Mock
//    UsersServiceImpl usersServiceImpl;
//
//    @Mock
//    UserRepository userRepository;
//
//
//    @InjectMocks
//    UserController userController;
//
//    @InjectMocks
//    TweetController  tweetController;
//
//    User user1=new User("xyz123","abc","def","abcdef@gmail.com","12345","12345","9078567543");
//    User user2=new User("jkl345","jkl","ert","jklert@gmail.com","09876","09876","8456790123");
//    Tweet tweet1=new Tweet("234","Greetings",user1,1, LocalDateTime.now(),"asdf");
//    Tweet tweet2=new Tweet("235","Review",user2,2, LocalDateTime.now(),"asdf");
//    User user1=new User("xyz123","abc","def","abcdef@gmail.com","12345","12345","9078567543");
//    User user2=new User("jkl345","jkl","ert","jklert@gmail.com","09876","09876","8456790123");
//
//    int a;
//    
//    @Test
//    void register() {
//
//        List<String> usernameList=new ArrayList<>();
//        usernameList.add(user1.getUsername());
//        usernameList.add(user2.getUsername());
//        User user3=new User("xy8123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        if(!usernameList.contains(user3.getUsername()))
//        {
//            a=1;
//        }
//        assertEquals(1,a);
//    }
//
//    @Test
//    void login() {
//        a=0;
//        User user3=new User("xyz123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        List<String> usernameList=new ArrayList<>();
//        List<String> usernameList1=new ArrayList<>();
//        usernameList.add(user1.getUsername());
//        usernameList1.add(user2.getUsername());
//        usernameList.add(user1.getPassword());
//        usernameList1.add(user2.getPassword());
//
//        if((usernameList.contains(user3.getUsername())&&(usernameList.contains(user3.getPassword())))||
//                (usernameList1.contains(user3.getUsername())&&(usernameList1.contains(user3.getPassword()))))
//        {
//            a=1;
//        }
//
//        assertEquals(1,a);
//    }
//
//    @Test
//    void forgetPassword() {
//
//        List<String> usernameList=new ArrayList<>();
//        usernameList.add(user1.getUsername());
//        usernameList.add(user2.getUsername());
//        User user3=new User("xyz123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        if(usernameList.contains(user3.getUsername()))
//        {
//            a=1;
//        }
//        assertEquals(1,a);
//
//    }
//
//    @Test
//    void resetPassword() {
//        User user3=new User("xyz123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        assertEquals(user3.getPassword(),user3.getConfirmPassword());
//
//    }
//
//    @Test
//    void getAllUser() {
//        List<User> usernameList=new ArrayList<>();
//        usernameList.add(user1);
//        usernameList.add(user2);
//        assertNotNull(usernameList);
//    }
//
//    @Test
//    void getAllUserBySearch() {
//        String username="xyz123";
//        List<String> usernameList=new ArrayList<>();
//        usernameList.add(user1.getUsername());
//        usernameList.add(user2.getUsername());
//        if(usernameList.contains(username))
//        {
//            a=1;
//        }
//        assertEquals(1,a);
//
//    }
//
//    @Test
//    void getUserByUsername() {
//        String username="xyz123";
//        List<String> usernameList=new ArrayList<>();
//        usernameList.add(user1.getUsername());
//        usernameList.add(user2.getUsername());
//        if(usernameList.contains(username))
//        {
//            a=1;
//        }
//        assertEquals(1,a);
//    }
//
//
//    @Test
//    void getAllTweet() {
//        List<Tweet> tweetList=new ArrayList<>();
//        tweetList.add(tweet1);
//        tweetList.add(tweet2);
//        assertNotNull(tweetList);
//    }
//
//    @Test
//    void getAllTweetByUsername() {
//                assertEquals(tweet1.getUser(),user1);
//    }
//
//    @Test
//    void postTweet() {
//        String id="234";
//        String id1=null;
//        Tweet tweet3;
//        List<String> tweetIdList=new ArrayList<>();
//        tweetIdList.add(tweet1.getId());
//        tweetIdList.add(tweet2.getId());
//        if(tweetIdList.contains(id))
//        {
//            tweet3=new Tweet("234","Review",user2,2, LocalDateTime.now(),"asdf");
//            id1=tweet3.getId();
//        }
//        assertEquals(id,id1);
//    }
//
//    @Test
//    void updateTweet() {
//        String id="234";
//        String id1=null;
//        Tweet tweet3;
//        List<String> tweetIdList=new ArrayList<>();
//        tweetIdList.add(tweet1.getId());
//        tweetIdList.add(tweet2.getId());
//        if(tweetIdList.contains(id))
//        {
//            tweet3=new Tweet("234","Review",user2,2, LocalDateTime.now(),"asdf");
//            id1=tweet3.getId();
//        }
//        assertEquals(id,id1);
//    }
//
//    @Test
//    void deleteTweet() {
//        String id="234";
//        String id1=null;
//        Tweet tweet3;
//        List<String> tweetIdList=new ArrayList<>();
//        tweetIdList.add(tweet1.getId());
//        tweetIdList.add(tweet2.getId());
//        if(tweetIdList.contains(id))
//        {
//            tweet3=new Tweet("234","Review",user2,2, LocalDateTime.now(),"asdf");
//            id1=tweet3.getId();
//        }
//        assertEquals(id,id1);
//    }
//
//    @Test
//    void likeTweet() {
//        String id="234";
//        long id1=0;
//        Tweet tweet3;
//        List<String> tweetIdList=new ArrayList<>();
//        tweetIdList.add(tweet1.getId());
//        tweetIdList.add(tweet2.getId());
//        if(tweetIdList.contains(id))
//        {
//            tweet3=new Tweet("234","Review",user2,2, LocalDateTime.now(),"asdf");
//            id1=tweet3.getLikes();
//        }
//        assertEquals(tweet1.getLikes()+1,id1);
//    }
//
//    @Test
//    void replyTweet() {
//        String username="xyz123";
//        String id=null;
//        String id1=null;
//        List<String> usernameList=new ArrayList<>();
//        usernameList.add(user1.getUsername());
//        usernameList.add(user2.getUsername());
//        if(usernameList.contains(username))
//        {
//            Tweet tweet3 = new Tweet("234", "Review", user2, 2, LocalDateTime.now(), "asdf");
//            id1=tweet3.getId();
//        }
//        assertNotNull(id1);
//    }
//}