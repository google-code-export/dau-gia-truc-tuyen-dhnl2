<?php foreach($comments as $comment): ?>
    <div class="comment">
        <div class="author">
            <?php echo $comment->createUser->username; ?>:
        </div>
        <div class="time">
            on <?php echo date('F j, Y \a\t h:i a',strtotime($comment->create_time)); ?>
        </div>
        <div class="content">Iteration 6: Adding User Comments
            [ 222 ]
            <?php echo nl2br(CHtml::encode($comment->content)); ?>
        </div>
        <hr>
    </div><!-- comment -->
    <?php endforeach; ?>