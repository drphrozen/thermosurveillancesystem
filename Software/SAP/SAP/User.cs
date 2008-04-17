using System;
using System.Collections.Generic;
using System.Text;
using SAP.AdminFacade;
using System.ComponentModel;

namespace SAP
{
    class User
    {
        public enum AccountType : int
        {
            ADMIN = 1,
            USER = 2,
            READINGSTATION = 3,
        }

        private AccountType accountTypeID;

        public AccountType AccountTypeID
        {
            get { return accountTypeID; }
            set { accountTypeID = value; }
        }

        private string password;

        [PasswordPropertyText(true)]
        public string Password
        {
            get { return password; }
            set { password = value; }
        }

        private string username;

        public string Username
        {
            get { return username; }
            set { username = value; }
        }

        public User()
        {
            accountTypeID = AccountType.USER;
            password = "";
            username = "";
        }

        public User(UserDTO user)
        {
            accountTypeID = (AccountType)user.accountTypeId;
            password = user.password;
            username = user.username;
        }

        /// <summary>
        /// Copy constructor
        /// </summary>
        /// <param name="user"></param>
        public User(User user)
        {
            accountTypeID = user.AccountTypeID;
            password = String.Copy(user.Password);
            username = String.Copy(user.Username);
        }

        public static User[] GetUsers(UserDTO[] users)
        {
            int length = users.Length;
            User[] usersOut = new User[length];
            for (int i = 0; i < length; i++)
                usersOut[i] = new User(users[i]);
            return usersOut;
        }

        public override string ToString()
        {
            return "Username: " + Username + ", account type: " + AccountTypeID;
        }

        public UserDTO GetUserDTO()
        {
            UserDTO user = new UserDTO();
            user.username = Username;
            user.password = Password;
            user.accountTypeId = (int)AccountTypeID;
            return user;
        }
    }
}
