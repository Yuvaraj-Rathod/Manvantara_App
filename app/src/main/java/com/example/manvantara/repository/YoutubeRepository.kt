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
}
