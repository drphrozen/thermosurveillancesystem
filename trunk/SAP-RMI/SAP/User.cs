using System;
using System.Collections.Generic;
using System.Text;
using SAP.AdminFacade;
using System.ComponentModel;
using dk.iha.onk.group1.dataTransferObjects;

namespace SAP
{
    class User
    {
        public enum AccountType : int
        {
            ADMIN = 1,
            USER = 2,
        }

        private AccountType accountTypeID;

        public AccountType AccountTypeID
        {
            get { return accountTypeID; }
            set { accountTypeID = value; }
        }

        private string password;

        [Browsable(false)]
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

        private int id;

        [ReadOnly(true)]
        public int ID
        {
            get { return id; }
            set { id = value; }
        }

        public User()
        {
            accountTypeID = AccountType.USER;
            password = "";
            username = "";
        }

        public User(UserDTO user)
        {
            id = user.getId();
            switch (user.getAccountType())
            {
                case "admin":
                    accountTypeID = AccountType.ADMIN;
                    break;
                case "user":
                    accountTypeID = AccountType.USER;
                    break;
                default:
                    throw new Exception(user.getAccountType() + " accounttype error!");
            }
            password = user.getPassword();
            username = user.getUsername();
        }

        /// <summary>
        /// Copy constructor
        /// </summary>
        /// <param name="user"></param>
        public User(User user)
        {
            id = user.ID;
            accountTypeID = user.AccountTypeID;
            password = (user.Password == null ? null : String.Copy(user.Password));
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
            user.setId(ID);
            user.setUsername(Username);
            user.setPassword(Password);
            user.setAccountType(Enum.GetName(typeof(AccountType), AccountTypeID).ToLower());
            return user;
        }
    }
}
