package com.example.manvantara.repository

import com.example.manvantara.model.YoutubeVideo
import javax.inject.Inject

class YoutubeRepository @Inject constructor() {
    fun DbmsPlaylist() : List<YoutubeVideo> {
        return listOf(
        YoutubeVideo("1. Introduction to DBMS Placements Course 2022", "https://www.youtube.com/watch?v=eYpXCdvKwEQ"),
        YoutubeVideo("2. What the heck is Database Management System (DBMS)?", "https://www.youtube.com/watch?v=TYo_CUnIWP8"),
        YoutubeVideo("3. DBMS Architecture || Role of DBA", "https://www.youtube.com/watch?v=mYI2nopkQJE"),
        YoutubeVideo("4. ER Model Explained || ER Diagram Notations || DBMS for Placements", "https://www.youtube.com/watch?v=kMHJhhIx5k4"),
        YoutubeVideo("5. Extended ER Features || Abstraction in ER Model", "https://www.youtube.com/watch?v=8_dMPX6_qiY"),
        YoutubeVideo("6. How to think and formulate an ER Diagram || Banking System ER Model", "https://www.youtube.com/watch?v=w-VfTUvxETQ"),
        YoutubeVideo("7. Designing the ER Model of FACEBOOK Database || DBMS for Placements", "https://www.youtube.com/watch?v=sQ1AcVYP18c"),
        YoutubeVideo("8. Relational Model Explained || DBMS for Placements", "https://www.youtube.com/watch?v=kUk8PgORTzo"),
        YoutubeVideo("9. Transform ER Model to Relational Model || ER-Diagram to Tables", "https://www.youtube.com/watch?v=_xHl2gpoXqI"),
        YoutubeVideo("10. Complete SQL in 1 VIDEO", "https://www.youtube.com/watch?v=D_wNQR3LeeM"),
        YoutubeVideo("11. Common SQL Queries for Interviews", "https://www.youtube.com/watch?v=vIq9zkpGWc8"),
        YoutubeVideo("12. Why We Need Normalisation ? || DBMS Series for Placements", "https://www.youtube.com/watch?v=nweGaymEwGM"),
        YoutubeVideo("13. ACID Properties && Transactions in DBMS", "https://www.youtube.com/watch?v=sS4gadQw5iM"),
        YoutubeVideo("14. How to Implement Atomicity and Durability? || DBMS Interview question", "https://www.youtube.com/watch?v=iNAaZNC7prE"),
        YoutubeVideo("15. Why Indexing is important in Database Systems || DBMS Interview question", "https://www.youtube.com/watch?v=Fr-0rNhIECw"),
        YoutubeVideo("16. What are NoSQL Databases || SQL vs NoSQL", "https://www.youtube.com/watch?v=hl65apHxp64"),
        YoutubeVideo("17. Types of Databases || DBMS for Placements", "https://www.youtube.com/watch?v=ItjrKq7c-h4"),
        YoutubeVideo("18. What is Clustering / Replication in DBMS || DBMS for Placements", "https://www.youtube.com/watch?v=Xt3HWe8W67Q"),
        YoutubeVideo("19. What is Partitioning and Sharding in DBMS || DB Optimisation", "https://www.youtube.com/watch?v=TlIX427wKDg"),
        YoutubeVideo("20. Database Scaling Patterns | How to perform step by step scaling", "https://www.youtube.com/watch?v=SOrhyETsz6w"),
        YoutubeVideo("21. CAP Theorem in DBMS || DBMS for Placements 2022", "https://www.youtube.com/watch?v=EIl02n-FxTg"),
        YoutubeVideo("22. Master-Slave Architecture || DBMS for Placements", "https://www.youtube.com/watch?v=_RS78xr2Dc4")
        )
    }

    fun OsPlaylist(): List<YoutubeVideo> {
        return listOf(
            YoutubeVideo("Lecture 1: Introduction to Operating Systems Placements Course 2022", "https://www.youtube.com/watch?v=_TpOHMCODXo"),
            YoutubeVideo("Lecture 2: What is an Operating System ?", "https://www.youtube.com/watch?v=a1l4MceYHaQ"),
            YoutubeVideo("Lecture 3: Types of Operating Systems", "https://www.youtube.com/watch?v=LBqNWOqSzBA"),
            YoutubeVideo("Lecture 4: Multi-Tasking vs Multi-Threading", "https://www.youtube.com/watch?v=iAnEvdCya6M"),
            YoutubeVideo("Lecture 5: Components of Operating System", "https://www.youtube.com/watch?v=kHMXP_i6zew"),
            YoutubeVideo("Lecture 6: System Calls in Operating System  [Theory + Example + Hands-on Terminal]", "https://www.youtube.com/watch?v=lo8Z61qCDqQ"),
            YoutubeVideo("Lecture 7: How Operating System Boots up?", "https://www.youtube.com/watch?v=nAr2sLiLDWw"),
            YoutubeVideo("Lecture 8: Difference between 32-bit & 64-bit Operating System", "https://www.youtube.com/watch?v=cE6WoaUnpAM"),
            YoutubeVideo("Lecture 9: Comparison between different STORAGES used in Computer", "https://www.youtube.com/watch?v=KFIStTj2DFw"),
            YoutubeVideo("Lecture 10: How OS creates a PROCESS  || Introduction to Process", "https://www.youtube.com/watch?v=ev4PrTlTKzE"),
            YoutubeVideo("Lecture 11: What are different Process States in Operating System ?", "https://www.youtube.com/watch?v=BoH-yzA2nj8"),
            YoutubeVideo("Lecture 12: Context Switching in OS | Medium Term Scheduler | Orphan/Zombie Process", "https://www.youtube.com/watch?v=arlIBez-W_I"),
            YoutubeVideo("Lecture 13: What is Convoy Effect | FCFS CPU Scheduling Algorithm", "https://www.youtube.com/watch?v=lLmqbQnLM4A"),
            YoutubeVideo("Lecture 14: Shortest Job First Algorithm | Priority Scheduling | Round Robin CPU Scheduling", "https://www.youtube.com/watch?v=AXrF0AmMYlc"),
            YoutubeVideo("Lecture 15: Multi Level Queue Scheduling || MLFQ  || Comparison btw CPU Scheduling Algorithms", "https://www.youtube.com/watch?v=ly5Ume_Crsk"),
            YoutubeVideo("Lecture 16: What is Concurrency ? || Multi-Threading in C++ || Operating Systems Placement Series", "https://www.youtube.com/watch?v=S7Aym-4-iUc"),
            YoutubeVideo("Lecture 17: Critical Section Problem || Race condition in OS", "https://www.youtube.com/watch?v=6NEJ3-nOQek"),
            YoutubeVideo("Lecture 18: Conditional Variables & Semaphores to Synchronise Threads", "https://www.youtube.com/watch?v=AeDvGSbnoBE"),
            YoutubeVideo("Lecture 19: Producer Consumer Problem and its Solution || OS Placement Series", "https://www.youtube.com/watch?v=lY64CSlnjpg"),
            YoutubeVideo("Lecture 20: Reader-Writer Problem and its Solution || OS Placement Series", "https://www.youtube.com/watch?v=TyJ3as7haIU"),
            YoutubeVideo("Lecture 21: The Dining Philosophers Problem & its Solution", "https://www.youtube.com/watch?v=PIaIJCUZbf4"),
            YoutubeVideo("Lecture 22: What is Deadlock | Necessary Conditions | Handling Methods | Part - 1", "https://www.youtube.com/watch?v=pkTekFvauhU"),
            YoutubeVideo("Lecture 23: Deadlock Avoidance | Deadlock Detection and Recovery | Part - 2", "https://www.youtube.com/watch?v=dupdUhx1fns"),
            YoutubeVideo("Lecture 24: Solving LeetCode Problems on Concurrency || OS Placement Series", "https://www.youtube.com/watch?v=pOfDCjYm6Kk"),
            YoutubeVideo("Lecture 25: Memory Management in OS || Contiguous Memory Allocation", "https://www.youtube.com/watch?v=ZNcArN7ODrw"),
            YoutubeVideo("Lecture 26: How OS manages Free Space? || Memory Management", "https://www.youtube.com/watch?v=_hrKEA1sEUo"),
            YoutubeVideo("Lecture 27: What is Paging? || Non-Contiguous Memory Allocation", "https://www.youtube.com/watch?v=P65WxiAjySs"),
            YoutubeVideo("Lecture 28: What is Segmentation || Non-Contiguous Memory Allocation", "https://www.youtube.com/watch?v=fRPz3dQ2LZc"),
            YoutubeVideo("Lecture 29: What is Virtual Memory? || Page fault in OS", "https://www.youtube.com/watch?v=U7wsluje5lU"),
            YoutubeVideo("Lecture 30: Page Replacement Algorithms || How to implement LRU algorithm?", "https://www.youtube.com/watch?v=S727dgU0pU8"),
            YoutubeVideo("Lecture 31: What is Thrashing? || Important Interview Question", "https://www.youtube.com/watch?v=gA34TuSHAHk")
        )
    }

    fun cnPlaylist(): List<YoutubeVideo> {
        return listOf(
            YoutubeVideo("Lecture 1: What is Computer Network?", "https://www.youtube.com/watch?v=7NFJGH4PzAs"),
            YoutubeVideo("Lecture 2: Five components of Data Communication | Computer Networks in Hindi", "https://www.youtube.com/watch?v=lGsJAbrMVa4"),
            YoutubeVideo("Lecture 3: Effectiveness of Data Communication in Computer Networks in Hindi", "https://www.youtube.com/watch?v=B8RHylzFjeA"),
            YoutubeVideo("Lecture 4: Transmission Mode in Data Communication | Simplex, Half-Duplex and Full-Duplex mode", "https://www.youtube.com/watch?v=bblYjfCvoJU"),
            YoutubeVideo("Lecture 5: Type of Connection Point-to-Point and Multi-Point Connection in Computer Networks", "https://www.youtube.com/watch?v=4jT7TG0NNhc"),
            YoutubeVideo("Lecture 6: Physical Topology in Computer Networks | Mesh Topology", "https://www.youtube.com/watch?v=ei5fvr6NHf4"),
            YoutubeVideo("Lecture 7: Star Topology in Computer Networks in Hindi - types of topology", "https://www.youtube.com/watch?v=GgV3wUsmi4U"),
            YoutubeVideo("Lecture 8: Bus Topology in Computer Networks in Hindi - types of topology", "https://www.youtube.com/watch?v=Q71kgKaUJRY"),
            YoutubeVideo("Lecture 9: Ring Topology in Computer Networks in Hindi - types of topology", "https://www.youtube.com/watch?v=xQC6vPlOd_s"),
            YoutubeVideo("Lecture 10: Basics of Open System Interconnection OSI model in Hindi and how it works", "https://www.youtube.com/watch?v=9nIhpzMv1BI"),
            YoutubeVideo("Lecture 11: Working of Open System Interconnection OSI model in Hindi", "https://www.youtube.com/watch?v=fZQ11oo9D7Y"),
            YoutubeVideo("Lecture 12: Basics of Physical Layer with functionality and duties in Hindi", "https://www.youtube.com/watch?v=vL9kQI0gDPU"),
            YoutubeVideo("Lecture 13: Data Link Layer duties, services and functionality in Hindi", "https://www.youtube.com/watch?v=5cPiRYtgTUI"),
            YoutubeVideo("Lecture 14: Network Layer duties, services and functionality in Hindi - Computer Networks", "https://www.youtube.com/watch?v=-qyAlUG81JU"),
            YoutubeVideo("Lecture 15: Transport Layer duties, services and functionality in Hindi - Computer Networks", "https://www.youtube.com/watch?v=FiZ2z6RwJQI"),
            YoutubeVideo("Lecture 16: Session Presentation Application Layer duties, services and functionality in Hindi", "https://www.youtube.com/watch?v=Cs9pwZmMywc"),
            YoutubeVideo("Lecture 17: Transmission Medium Wired & Guided Twisted Pair Cable Coaxial Cable Optical Fiber", "https://www.youtube.com/watch?v=rzVlWMkvdKM"),
            YoutubeVideo("Lecture 18: Access Control in Data Link Layer in Hindi | Computer Network", "https://www.youtube.com/watch?v=jxcW3Wfj8s8"),
            YoutubeVideo("Lecture 19: Propagation Time Vs Transmission Time in Hindi", "https://www.youtube.com/watch?v=SwB7NSEkD_A"),
            YoutubeVideo("Lecture 20: Everything About Pure ALOHA", "https://www.youtube.com/watch?v=iAsGKAj-bcY"),
            YoutubeVideo("Lecture 21: Everything About Slotted ALOHA", "https://www.youtube.com/watch?v=9lEvqxp9ODQ"),
            YoutubeVideo("Lecture 22: CSMA Carrier Sense Multiple Access", "https://www.youtube.com/watch?v=ANuoGgUJs5g"),
            YoutubeVideo("Lecture 23: Persistence Methods in CSMA 1-Persistent Non-Persistent P-Persistent", "https://www.youtube.com/watch?v=ATV4uoYpV8w"),
            YoutubeVideo("Lecture 24: CSMA/CD Carrier Sense Multiple Access With Collision Detection", "https://www.youtube.com/watch?v=HyPiw5XWV0c"),
            YoutubeVideo("Lecture 25: CSMA/CA Carrier Sense Multiple Access With Collision Avoidance", "https://www.youtube.com/watch?v=Cm6Vv0Ds8tk"),
            YoutubeVideo("Lecture 26: Controlled Access Methods Reservation Polling Token Passing", "https://www.youtube.com/watch?v=pF8n3j9ucds"),
            YoutubeVideo("Lecture 27: FDMA TDMA CDMA Channelization Protocol", "https://www.youtube.com/watch?v=4x0oT7AeNYs"),
            YoutubeVideo("Lecture 28: Stop-and-Wait ARQ Sliding Window Protocol", "https://www.youtube.com/watch?v=HFNbkmub6MQ"),
            YoutubeVideo("Lecture 29: Go-Back-N ARQ Sliding Window Protocol", "https://www.youtube.com/watch?v=oSEUqV_XuNI"),
            YoutubeVideo("Lecture 30: Selective Repeat ARQ Sliding Window Protocol", "https://www.youtube.com/watch?v=uM4glyAWD4Q"),
            YoutubeVideo("Lecture 31: IPV4 Header Structure in Hindi | Fields in IPV4 Header in Hindi", "https://www.youtube.com/watch?v=7z8A8EQik_w"),
            YoutubeVideo("Lecture 32: IPV4 Header Version Field in Hindi | Version Field in IPV4 Header Hindi", "https://www.youtube.com/watch?v=8ghyUgREJOI"),
            YoutubeVideo("Lecture 33: IPV4 Header Length In Hindi | Header Length in Hindi", "https://www.youtube.com/watch?v=ZzEvv-fC52M"),
            YoutubeVideo("Lecture 34: IPV4 Header Time To Live Field in Hindi | TTL field in Hindi", "https://www.youtube.com/watch?v=xoD49fOau7g"),
            YoutubeVideo("Lecture 35: IPV4 Header PROTOCOL field in Hindi | PROTOCOL field in Hindi", "https://www.youtube.com/watch?v=G3qCqUhYqrs"),
            YoutubeVideo("Lecture 36: What is Logical or IP Addressing", "https://www.youtube.com/watch?v=7W5cUJV5FvY"),
            YoutubeVideo("Lecture 37: Classful Addressing Complete Discussion", "https://www.youtube.com/watch?v=P7g--FJdUXE"),
            YoutubeVideo("Lecture 38: Complete Subnetting in One video", "https://www.youtube.com/watch?v=QmAqpEkXAvo"),
            YoutubeVideo("Lecture 39: Types of Casting in Computer Networks Unicast Broadcast Multicast", "https://www.youtube.com/watch?v=eWb35_xIKho")
        )
    }

    fun dsaPlaylist(): List<YoutubeVideo> {
        return listOf(
            YoutubeVideo("Lecture 1: Flowchart & Pseudocode + Installation | DSA Series by Shradha Ma'am | C++", "https://www.youtube.com/watch?v=VTLCoHnyACE"),
            YoutubeVideo("Lecture 2: Variable, Data Types & Operators | DSA Series by Shradha Ma'am | C++", "https://www.youtube.com/watch?v=Dxu7GKtdbnA"),
            YoutubeVideo("Lecture 3: Conditional Statements & Loops | DSA Series by Shradha Ma'am | C++", "https://www.youtube.com/watch?v=qR9U6bKxJ7g"),
            YoutubeVideo("Lecture 4: Patterns | DSA Series by Shradha Khapra Ma'am | C++", "https://www.youtube.com/watch?v=rga_q2N7vU8"),
            YoutubeVideo("Lecture 5: Functions | DSA Series by Shradha Khapra Ma'am | C++", "https://www.youtube.com/watch?v=P08Z_NC8GuY"),
            YoutubeVideo("Lecture 6: Binary Number System | DSA Series by Shradha Khapra Ma'am | C++", "https://www.youtube.com/watch?v=xpy5NXiBFvA"),
            YoutubeVideo("Lecture 7: Bitwise Operators, Data Type Modifiers & more | DSA Series by Shradha Khapra Ma'am | C++", "https://www.youtube.com/watch?v=r-u4uh3QvsQ"),
            YoutubeVideo("Lecture 8: Array Data Structure - Part 1 | DSA Series by Shradha Khapra Ma'am | C++", "https://www.youtube.com/watch?v=8wmn7k1TTcI"),
            YoutubeVideo("Lecture 9: Vectors in C++ | Arrays Part 2 | DSA Series by Shradha Ma'am", "https://www.youtube.com/watch?v=NWg38xWYzEg"),
            YoutubeVideo("Lecture 10: Kadane's Algorithm | Maximum Subarray Sum | DSA Series by Shradha Ma'am", "https://www.youtube.com/watch?v=9IZYqostl2M"),
            YoutubeVideo("Lecture 11: Majority Element | Brute- Better-Best Approach | Moore's Voting Algorithm & Pair Sum", "https://www.youtube.com/watch?v=_xqIp2rj8bo"),
            YoutubeVideo("Lecture 12: Time & Space Complexity - DSA Series by Shradha Ma'am", "https://www.youtube.com/watch?v=PwKv8fOcriM"),
            YoutubeVideo("Lecture 13: Buy and Sell Stock Problem and Pow(X,N) Power Exponential Problem - Leetcode | DSA Series", "https://www.youtube.com/watch?v=WBzZCm46mFo"),
            YoutubeVideo("Lecture 14: Container with Most Water Problem | Brute & Optimal Solution | Two Pointer Approach - Leetcode 11", "https://www.youtube.com/watch?v=EbkMABpP52U"),
            YoutubeVideo("Lecture 15: Product of Array Except Self | Brute to Optimal Solution | Leetcode 238", "https://www.youtube.com/watch?v=TW2m8m_FNJE"),
            YoutubeVideo("Lecture 16: Pointers in C++ | In Detail | DSA Series by Shradha Ma'am", "https://www.youtube.com/watch?v=qYEjR6M0wSk"),
            YoutubeVideo("Lecture 17: Binary Search Algorithm - Iterative and Recursive Method | [Theory + Code] with Example", "https://www.youtube.com/watch?v=TbbSJrY5GqQ"),
            YoutubeVideo("Lecture 18: Search in Rotated Sorted Array | Binary Search | Leetcode 33", "https://www.youtube.com/watch?v=6WNZQBHWQJs"),
            YoutubeVideo("Lecture 19: Peak Index in Mountain Array | Binary Search | Leetcode 852", "https://www.youtube.com/watch?v=RjxD6UXGlhc"),
            YoutubeVideo("Lecture 20: Single Element in Sorted Array | Binary Search | DSA Series", "https://www.youtube.com/watch?v=qsbCBduIs40")
        )
    }

}
