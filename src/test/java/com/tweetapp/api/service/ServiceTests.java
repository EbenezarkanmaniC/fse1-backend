//package com.tweetapp.service;
//
//import com.tweetapp.exception.InvalidUserNameOrPassword;
//import com.tweetapp.exception.UserAlreadyExist;
//import com.tweetapp.exception.UserNotFound;
//import com.tweetapp.model.User;
//import com.tweetapp.model.UserResponse;
//import com.tweetapp.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//class UsersServiceImplTest {
//	@Autowired
//    MockMvc mockMvc;
//
//    @Mock
//    TweetRepository tweetRepository;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    TweetServiceImpl tweetService;
//
//    @InjectMocks
//    UsersServiceImpl usersService;
//
//    @SuppressWarnings("deprecation")
//    @BeforeEach
//    public void init()
//    {
//        MockitoAnnotations.initMocks(this);
//    }
//    private User user1;
//    private User user2;
//    private Tweet tweet1;
//    private Tweet tweet2;
//    private Tweet tweet3;
//    private Tweet tweet4;
//
//    @BeforeEach
//    public void setup(){
//        user1 = new User("xy8123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        user2 = new User("xy8123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        tweet1 = new Tweet("234", "Review", user1, 2, LocalDateTime.now(), "asdf");
//        tweet2 = new Tweet("235", "Greetings", user2, 2, LocalDateTime.now(), "tyur");
//    }
//
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @InjectMocks
//    UsersServiceImpl usersService;
//
//    @Mock
//    UserRepository userRepository;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    private User user1;
//    private User user2;
//    private User user3;
//    private UserResponse response;
//
//    @BeforeEach
//    public void setup() {
//        user1 = new User( "xy8123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        response = new UserResponse(user1,"active","jhsdi","No error");
//
//    }
//
//    @Test
//    void register() {
//        when(userRepository.save(user1)).thenReturn(user1);
//        assertTrue(usersService.register(user1).equals(user1));
//        verify(userRepository).save(user1);
//    }
//
//    @Test
//    public void invalidRegister() throws Exception {
//        user2 = new User("xy8123","jkl","ert","jklert@gmail.com","12345","12345","8456790123");
//        when(userRepository.findByUsername("xy8123")).thenReturn(user1);
//        assertThrows(UserAlreadyExist.class, () -> {
//            usersService.register(user2);
//        });
//        verify(userRepository).findByUsername("xy8123");
//    }
//
//    @Test
//    void forgetPassword() {
//
//        when(userRepository.findByUsername("xy8123")).thenReturn(user1);
//        assertTrue(usersService.forgetPassword("xy8123").equals(user1));
//        verify(userRepository).findByUsername("xy8123");
//    }
//
//    @Test
//    void resetPassword() {
//        when(userRepository.save(user1)).thenReturn(user1);
//        when(userRepository.findByUsername("xy8123")).thenReturn(user1);
//        assertTrue(usersService.resetPassword("xy8123", "12345","12345").equals(user1));
//        verify(userRepository).save(user1);
//    }
//    @Test
//    void invalidResetPassword() {
//        user2 = new User("xyz123","jkl","ert","jklert@gmail.com","12345","12346","8456790123");
//        when(userRepository.findByUsername("xyz123")).thenReturn(null);
//        assertThrows(UserNotFound.class, () -> {
//            usersService.resetPassword(user2.getUsername(),user2.getPassword(),user2.getConfirmPassword());
//        });
//        verify(userRepository).findByUsername("xyz123");
//    }
//
//    @Test
//    void getAllUser() {
//        when(userRepository.findAll()).thenReturn(Arrays.asList(user1));
//        assertThat(usersService.getAllUser()).hasSize(1);
//    }
//
//    @Test
//    void getAllUserBySearch() {
//        when(userRepository.findAllByUsername("xy8123")).thenReturn(List.of(user1));
//        assertTrue(usersService.getAllUserBySearch("xy8123").equals(Arrays.asList(user1)));
//        verify(userRepository).findAllByUsername("xy8123");
//    }
//
//    @Test
//    void getUserByUsername() {
//        when(userRepository.findByUsername("xy8123")).thenReturn(user1);
//        assertTrue(usersService.getUserByUsername("xy8123").equals(user1));
//        verify(userRepository).findByUsername( "xy8123");
//    }
//
//    @Test
//    void login() {
//        when(userRepository.findByUsername("xy8123")).thenReturn(user1);
//        assertThat(usersService.login(user1).getPassword()).isEqualTo(user1.getPassword());
//        verify(userRepository).findByUsername("xy8123");
//
//    }
//    @Test
//    void invalidLogin() {
//        user2 = new User("xyz123","jkl","ert","jklert@gmail.com","12346","12346","8456790123");
//        when(userRepository.findByUsername("xyz123")).thenReturn(user1);
//        assertThrows(InvalidUserNameOrPassword.class, () -> {
//            usersService.login(user2);
//        });
//        verify(userRepository).findByUsername("xyz123");
//    }
//    @Test
//    void getAllTweet() {
//        when(tweetRepository.findAll()).thenReturn(Arrays.asList(tweet1));
//        assertNotNull(tweetService.getAllTweet());
//    }
//
//    @Test
//    void postTweet() {
//        tweet3 = new Tweet("236", "Debate", user2, 2, LocalDateTime.now(), "uiop");
//        when(tweetRepository.save(tweet3)).thenReturn(tweet3);
//        when(userRepository.findByUsername("xy8123")).thenReturn(user1);
//        assertTrue(tweetService.postTweet(tweet3,"xy8123").equals(tweet3));
//        verify(tweetRepository).save(tweet3);
//    }
//
//    @Test
//    void updateTweet() {
//
//        when(tweetRepository.save(tweet1)).thenReturn(tweet1);
//        assertTrue(tweetService.updateTweet(tweet1,tweet1.getTweetName(),tweet1.getId()).equals(tweet1));
//        verify(tweetRepository).save(tweet1);
//    }
//
//    @Test
//    void deleteTweet() {
//        when(tweetRepository.findById("1")).thenReturn(Optional.of(tweet1));
//        assertNull(tweetService.deleteTweet("1","xy8123"));
//    }
//
//    @Test
//    void likeTweet() {
//        when(tweetRepository.save(tweet1)).thenReturn(tweet1);
//        assertTrue(tweetService.likeTweet(tweet1,tweet1.getTweetName(),tweet1.getId()).equals(tweet1));
//        verify(tweetRepository).save(tweet1);
//    }
//
//    @Test
//    void replyTweet() {
//        when(tweetRepository.save(tweet1)).thenReturn(tweet1);
//        assertNotNull(tweet1);
//
//    }
//
//    @Test
//    void getAllTweetByUsername() {
//        when(tweetRepository.findByUserUsername("xy8123")).thenReturn( tweet1);
//        assertTrue(tweetService.getAllTweetByUsername("xy8123").equals(tweet1));
//        verify(tweetRepository).findByUserUsername("xy8123");
//    }
//
//    }