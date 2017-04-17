---
layout: default
title:  How to Work with Gerrit Code Review in ci.csn.khai.edu
description: A brief instruction on how to work with Gerrit in ci.csn.khai.edu
keywords: work in gerrit, git-review, Gerrit Code Review, ci, ci.csn.khai.edu, how to
category: faq
i18n-link: how-to-work-with-gerrit-in-cicsnkhaiedu
---

# How to Work with Gerrit Code Review in ci.csn.khai.edu

* TOC
{:toc}

If you are first time in Gerrit Code Review here we will take a short tour and look (in more details)
how to start contributing to any projects (or perform labs), make code review or place comments in
[Gerrit Code Review](http://ci.csn.khai.edu/gerrit) of `ci.csn.khai.edu`.


> ***NOTE:***
> In order to start contributing to any projects, make code review or place comments
> in [Gerrit Code Review](http://ci.csn.khai.edu/gerrit) of `ci.csn.khai.edu` you **must** have an account
> in **`@csn.khai.edu`** (**`@student.csn.khai.edu`**) domain.

## How to configure Gerrit Code Review account

1. [Sign in](http://ci.csn.khai.edu/gerrit) with your **`@student.csn.khai.edu`** account in Gerrit Code Review:

   ![Image]({{ site.url }}{% link /assets/images/how-to/sign_in_gerrit.png %})


2. Go to your personal (profile) [Settings](http://ci.csn.khai.edu/gerrit/#/settings/) page:

   ![Image]({{ site.url }}{% link /assets/images/how-to/personal-settings-gerrit.png %})


3. In `'Settings` &#8594; `Profile'` specify `Username` and then click `'Select Username'` button.

   > ***NOTE:***
   > Please, note that `Username` **cannot be changed**, so set it **very carefully** according to
   > the following rule: **first letter** of your name + your **surname** (see your email account as an example),
   > e.g. `Vitalii Kulanov (vkulanov)`, `Andrey Popov (apopov)`.

   ![Image]({{ site.url }}{% link /assets/images/how-to/set-user-settings-gerrit.png %})

4. If there is a need you can also modify your `'Contact information'` (e.g. if your fullname is not displayed correctly
due to encoding problem) in `'Settings` &#8594; `Contact Information'`:

   ![Image]({{ site.url }}{% link /assets/images/how-to/set-user-fullname-gerrit.png %})

5. Add your personal SSH Public Key in account from `'Settings` &#8594; `SSH Public Keys'` menu.

   > ***NOTE:***
   > You can find some additional information about SSH and how to configure SSH key pair in
   > ["Connecting to GitHub with SSH"](https://help.github.com/articles/connecting-to-github-with-ssh/) on GitHub.

   ![Image]({{ site.url }}{% link /assets/images/how-to/set-user-ssh-gerrit.png %})

6. If you need to customize some other preferences (Gerrit theme, data/time format etc.)
check the rest items of `'Settings'` menu.

Now you are ready to contribute to [any project](http://ci.csn.khai.edu/gerrit/#/admin/projects/) in
Gerrit Code Review of `ci.csn.khai.edu`.

## How to start contributing in ci.csn.khai.edu

> ***NOTE:***
> Before start contributing you have to be sure that `Git` and `Gerrit/git-review` is already installed and
> properly configured in your OS. Some basic examples about
> [how to configure Git in Windows](http://guides.beanstalkapp.com/version-control/git-on-windows.html)
> and [install git-review (Gerrit) in Windows]({{ site.url }}{% post_url 2017-02-25-how-to-install-git-review-in-windows %}).

> ***NOTE:***
> The rest examples in this chapter is performed for Ubuntu 16.04.2 LTS

If you are a beginner it is **strongly recommended** to start your work with playground project
called `'cicsnkhaiedu-dev/sandbox'`.

1. Find `'cicsnkhaiedu-dev/sandbox'` project. Select `'List'` menu item from top bar menu,
`'Projects` &#8594; `List'`, type the name of the project in the `'Filter'` field and select it.

   ![Image]({{ site.url }}{% link /assets/images/how-to/search-project-gerrit.png %})

2. Clone `'cicsnkhaiedu-dev/sandbox'` project to your system. Click on `'ssh'` menu item and copy
highlighted code line:

   ```bash
   git clone ssh://vkulanov@ci.csn.khai.edu:29418/cicsnkhaiedu-dev/sandbox
   ```
   ![Image]({{ site.url }}{% link /assets/images/how-to/clone-project-gerrit.png %})

   Paste copied code to the terminal window and execute it:

   ```bash
   machin@machin:/tmp/projects$ git clone ssh://vkulanov@ci.csn.khai.edu:29418/cicsnkhaiedu-dev/sandbox
   Cloning into 'sandbox'...
   remote: Counting objects: 3, done
   remote: Finding sources: 100% (3/3)
   remote: Total 3 (delta 0), reused 3 (delta 0)
   Receiving objects: 100% (3/3), done.
   Checking connectivity... done.
   machin@machin:/tmp/projects$ ls
   sandbox
   machin@machin:/tmp/projects$ tree .
   .
   └── sandbox
       └── README.md

   1 directory, 1 file
   ```

   As you can see cloned `sandbox` project contains single `README.md` file.

3. Edit `README.md` file with your favourite Text Editor.
4. Check for changes in your local repository executing `git status` command:

   ```bash
   machin@machin:/tmp/projects/sandbox$ git status
   On branch master
   Your branch is up-to-date with 'origin/master'.
   Changes not staged for commit:
     (use "git add <file>..." to update what will be committed)
     (use "git checkout -- <file>..." to discard changes in working directory)

	 modified:   README.md

   no changes added to commit (use "git add" and/or "git commit -a")
   ```

5. You can see the exact changes that took place (differences between current branch and remote
origin/master) executing `git diff origin/master`:

   ```bash
   machin@machin:/tmp/projects/sandbox$ git diff origin/master
   diff --git a/README.md b/README.md
   index dad16bd..b7731c4 100644
   --- a/README.md
   +++ b/README.md
   @@ -1 +1,3 @@
   # Hello from sandbox
   +
   +This is a change
   ```

6. Add file contents to the index executing `git add` command:

   ```bash
   machin@machin:/tmp/projects/sandbox$ git add README.md
   machin@machin:/tmp/projects/sandbox$ git status
   On branch master
   Your branch is up-to-date with 'origin/master'.
   Changes to be committed:
     (use "git reset HEAD <file>..." to unstage)

    modified:   README.md

   ```

7. Record (commit) changes to the repository executing `git commit` command:

   > ***NOTE:***
   > See documentation on [Git Commit Good Practice](https://wiki.openstack.org/wiki/GitCommitMessages)

   Here is a small example of commit message:

   ```bash
   Add small changes to README.md file

   This is the first commit to 'sandbox' project

   # Please enter the commit message for your changes. Lines starting
   # with '#' will be ignored, and an empty message aborts the commit.
   # On branch master
   # Your branch is up-to-date with 'origin/master'.
   #
   # Changes to be committed:
   #       modified:   README.md
   #
   ```
   And the result of `git commit` command execution is following:

   ```bash
   [master 53d83e2] Add small changes to README.md file
   1 file changed, 2 insertions(+)
   machin@machin:/tmp/sandbox$ git status
   On branch master
   Your branch is ahead of 'origin/master' by 1 commit.
     (use "git push" to publish your local commits)
   nothing to commit, working directory clean
   ```

8. Send all changes on review to [Gerrit Code Review](http://ci.csn.khai.edu/gerrit) executing `git review` command
(**!!! not** `git push`)

   > ***NOTE:***
   > If you do this first time the system will ask your `Username`

   ```bash
   machin@machin:/tmp/sandbox$ git review
   Creating a git remote called "gerrit" that maps to:
	      ssh://vkulanov@ci.csn.khai.edu:29418/cicsnkhaiedu-dev/sandbox
   Your change was committed before the commit hook was installed.
   Amending the commit to add a gerrit change id.
   remote: Processing changes: new: 1, refs: 1, done
   remote:
   remote: New Changes:
   remote:   http://ci.csn.khai.edu/gerrit/2 Add small changes to README.md file
   remote:
   To ssh://vkulanov@ci.csn.khai.edu:29418/cicsnkhaiedu-dev/sandbox
     * [new branch]      HEAD -> refs/publish/master
   ```
9. You can check (Top bar menu `My` &#8594; `Changes`, section `Outgoing reviews`), that newly added patch set
was created and ready for review:

   > ***NOTE:***
   > Commit message header of a patch set is displayed as a title in Gerrit Review System

   ![Image]({{ site.url }}{% link /assets/images/how-to/project-ls-gerrit.png %})


